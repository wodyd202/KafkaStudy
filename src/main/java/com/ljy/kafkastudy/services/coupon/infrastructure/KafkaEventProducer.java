package com.ljy.kafkastudy.services.coupon.infrastructure;

import com.ljy.kafkastudy.services.coupon.service.EventProducer;
import com.ljy.kafkastudy.services.coupon.service.event.DownloadedCouponEvent;
import com.ljy.kafkastudy.services.coupon.service.resource.DownloadCouponResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.ljy.kafkastudy.services.coupon.domain.Coupon.CouponType.LIMITED;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaEventProducer implements EventProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${ljy.kafka.topic.coupon-download}")
    private String TOPIC;

    @Override
    @Transactional
    public void publish(DownloadedCouponEvent event) {
        for (DownloadCouponResource coupon : event.getCouponIds()) {
            if (coupon.isLimitedCouponDownload()) {
                kafkaTemplate.send(TOPIC, LIMITED.name(), coupon);
            } else {
                kafkaTemplate.send(TOPIC, coupon);
            }
        }
    }
}

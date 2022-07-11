package com.ljy.kafkastudy.services.coupon.service;

import com.ljy.kafkastudy.services.coupon.service.dto.CouponDownloadDto;
import com.ljy.kafkastudy.services.coupon.service.event.DownloadedCouponEvent;
import com.ljy.kafkastudy.services.coupon.service.resource.DownloadCouponResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ljy.kafkastudy.services.coupon.domain.Coupon.CouponType.LIMITED;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final EventProducer producer;

    public void download(CouponDownloadDto dto) {
        long userId = dto.getUserId();
        List<DownloadCouponResource> couponIds = dto.getCouponIds()
                .stream()
                .map(id -> new DownloadCouponResource(id, LIMITED))
                .collect(toList());

        DownloadedCouponEvent event = new DownloadedCouponEvent(userId, couponIds);
        producer.publish(event);
    }
}

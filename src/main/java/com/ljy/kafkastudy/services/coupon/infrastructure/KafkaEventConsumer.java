package com.ljy.kafkastudy.services.coupon.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaEventConsumer implements AcknowledgingMessageListener<String, String> {

    @Override
    @KafkaListener(topics = "${ljy.kafka.topic.coupon-download}", groupId = "ljy-coupon", containerFactory = "kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
        log.info("partition : {}, key : {}, value : {}", consumerRecord.partition(), consumerRecord.key(), consumerRecord.value());
        acknowledgment.acknowledge();
    }
}

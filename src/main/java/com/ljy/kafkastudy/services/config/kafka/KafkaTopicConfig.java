package com.ljy.kafkastudy.services.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic newTopic() {
        return new NewTopic("coupon-download", 10, (short) 1);
    }
}

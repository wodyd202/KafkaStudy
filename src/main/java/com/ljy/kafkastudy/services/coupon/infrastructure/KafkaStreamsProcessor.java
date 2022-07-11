package com.ljy.kafkastudy.services.coupon.infrastructure;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class KafkaStreamsProcessor {

    @PostConstruct
    void setUp(StreamsBuilder streamsBuilder) {
        KStream<String, String> stream = streamsBuilder.stream("coupon-download", Consumed.with(Serdes.String(), Serdes.String()));
        stream.filter((i, s) -> {
            System.out.println(s);
            return s != null;
        })
        .to("coupon-download-test");
    }
}

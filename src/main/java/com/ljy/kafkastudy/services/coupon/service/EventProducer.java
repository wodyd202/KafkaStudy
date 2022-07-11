package com.ljy.kafkastudy.services.coupon.service;

import com.ljy.kafkastudy.services.coupon.service.event.DownloadedCouponEvent;

public interface EventProducer {
    void publish(DownloadedCouponEvent event);
}

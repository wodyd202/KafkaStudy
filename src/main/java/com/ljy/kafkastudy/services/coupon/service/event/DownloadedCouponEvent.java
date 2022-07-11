package com.ljy.kafkastudy.services.coupon.service.event;

import com.ljy.kafkastudy.services.coupon.service.resource.DownloadCouponResource;
import lombok.Getter;

import java.util.List;

@Getter
public class DownloadedCouponEvent implements Event{
    private final long userId;
    private final List<DownloadCouponResource> couponIds;

    public DownloadedCouponEvent(long userId, List<DownloadCouponResource> couponIds) {
        this.userId = userId;
        this.couponIds = couponIds;
    }
}

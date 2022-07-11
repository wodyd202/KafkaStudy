package com.ljy.kafkastudy.services.coupon.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {
    public enum CouponType {
        LIMITED, DOWNLOAD, RANDOM
    }

    private long id;
    private CouponType type;

    public Coupon(CouponType type) {
        this.type = type;
    }
}

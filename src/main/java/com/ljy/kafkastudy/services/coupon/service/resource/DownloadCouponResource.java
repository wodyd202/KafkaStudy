package com.ljy.kafkastudy.services.coupon.service.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ljy.kafkastudy.services.coupon.domain.Coupon.CouponType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DownloadCouponResource {
    private final long id;
    private final CouponType type;

    @JsonIgnore
    public boolean isLimitedCouponDownload() {
        return CouponType.LIMITED.equals(type);
    }
}

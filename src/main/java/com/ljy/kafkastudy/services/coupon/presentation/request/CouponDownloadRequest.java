package com.ljy.kafkastudy.services.coupon.presentation.request;

import lombok.Getter;

import java.util.List;

@Getter
public class CouponDownloadRequest {
    private List<Long> couponIds;
}

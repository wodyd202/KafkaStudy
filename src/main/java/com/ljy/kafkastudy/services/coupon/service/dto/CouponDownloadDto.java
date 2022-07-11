package com.ljy.kafkastudy.services.coupon.service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class CouponDownloadDto {
    private final long userId;
    private final List<Long> couponIds;
}

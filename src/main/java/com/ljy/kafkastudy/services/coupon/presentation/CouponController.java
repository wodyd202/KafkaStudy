package com.ljy.kafkastudy.services.coupon.presentation;

import com.ljy.kafkastudy.services.coupon.presentation.request.CouponDownloadRequest;
import com.ljy.kafkastudy.services.coupon.service.CouponService;
import com.ljy.kafkastudy.services.coupon.service.dto.CouponDownloadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<Long> couponDownload(@RequestHeader("user_id") long userId,
                                               @RequestBody CouponDownloadRequest request) {
        CouponDownloadDto dto = new CouponDownloadDto(userId, request.getCouponIds());
        couponService.download(dto);
        return ResponseEntity.ok(userId);
    }
}

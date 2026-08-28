package com.nexusmarket.app.domain.models;

import com.nexusmarket.app.domain.enums.RefundStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Refund {
    private Long id;
    private Long orderId;
    private Long administratorId;
    private Double refundAmount;
    private String reason;
    private RefundStatus status;
}

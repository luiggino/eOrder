package com.palbol.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlusMinusRequestDTO {
    private Long productId;
    private Integer orderQuantity;
    private Long orderId;
}

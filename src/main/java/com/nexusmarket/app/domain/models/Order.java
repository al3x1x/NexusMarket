package com.nexusmarket.app.domain.models;

import com.nexusmarket.app.domain.enums.OrderStatus;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private Long buyerId;
    private OrderStatus status;
    private List<OrderItem> items;
}

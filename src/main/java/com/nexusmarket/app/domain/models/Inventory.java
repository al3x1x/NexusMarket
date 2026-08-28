package com.nexusmarket.app.domain.models;

import com.nexusmarket.app.domain.enums.InventoryCondition;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private Long id;
    private Long productId;
    private Long warehouseId;
    private Integer availableQuantity;
    private InventoryCondition condition;
    private List<InventoryMovement> movements;
}

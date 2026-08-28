package com.nexusmarket.app.domain.models;

import com.nexusmarket.app.domain.enums.MovementType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryMovement {
    private MovementType movementType;
    private Integer quantity;
}

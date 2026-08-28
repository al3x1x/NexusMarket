package com.nexusmarket.app.domain.models;

import com.nexusmarket.app.domain.enums.WarehouseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    private Long id;
    private WarehouseType warehouseType;
}

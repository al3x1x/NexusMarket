package com.nexusmarket.app.domain.models;

import com.nexusmarket.app.domain.enums.ShipmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {
    private Long id;
    private Long orderId;
    private Long logisticOperatorId;
    private Address destinationAddress;
    private ShipmentStatus trackingStatus;
}

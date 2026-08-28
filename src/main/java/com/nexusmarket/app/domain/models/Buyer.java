package com.nexusmarket.app.domain.models;

import com.nexusmarket.app.domain.enums.CommercialStatus;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Buyer extends User {
    private Address primaryAddress;
    private List<Address> additionalAddresses;
    private CommercialStatus commercialStatus;
}

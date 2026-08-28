package com.nexusmarket.app.domain.models;

import com.nexusmarket.app.domain.enums.ProductStatus;
import com.nexusmarket.app.domain.enums.ProductType;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private ProductType productType;
    private List<String> variants;
    private ProductStatus status;
}

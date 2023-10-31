package com.ecommerce.product.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    private UUID id;

    private Category category;

    private String productTitle;

    private String imageUrl;

    private String skuCode;

    private Float unitValue;


}

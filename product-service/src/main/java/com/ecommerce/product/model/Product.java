package com.ecommerce.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private UUID id;

    private Category category;

    private String productTitle;

    private String imageUrl;

    private String skuCode;

    private Float unitValue;


}

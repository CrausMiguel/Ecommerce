package com.ecommerce.product.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    private UUID id;
    private String description;
    private Float value;


}
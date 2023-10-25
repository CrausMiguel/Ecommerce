package com.ecommerce.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private UUID id;
    private String description;
    private Float value;

}

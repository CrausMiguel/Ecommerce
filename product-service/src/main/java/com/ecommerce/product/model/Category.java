package com.ecommerce.product.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    private UUID id;

    private String categoryTitle;

    private String imageUrl;
}

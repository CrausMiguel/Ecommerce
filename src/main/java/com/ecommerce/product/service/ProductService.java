package com.ecommerce.product.service;

import com.ecommerce.product.dto.ProductRequest;

import com.ecommerce.product.dto.ProductResponse;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product newProduct = new Product();

        BeanUtils.copyProperties(productRequest, newProduct);

        productRepository.save(newProduct);

        log.info("Product {} is saved", newProduct.getId());
    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products
                        .stream()
                            .map(this::mapToProductResponse)
                        .toList();
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse
                .builder()
                .id(product.getId())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}

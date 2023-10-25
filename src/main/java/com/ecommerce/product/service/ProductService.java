package com.ecommerce.product.service;

import com.ecommerce.product.dto.ProductRequest;

import com.ecommerce.product.dto.ProductResponse;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@Service

public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product newProduct = new Product();
        BeanUtils.copyProperties(productRequest, newProduct, "id");
        productRepository.save(newProduct);
        log.info("Product {} is saved", newProduct.getId());
    }

    public ProductResponse getProduct(UUID id){
        ProductResponse productResponse = new ProductResponse();
        Product getProduct = productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        BeanUtils.copyProperties(getProduct, productResponse);
        return productResponse;
    }

}

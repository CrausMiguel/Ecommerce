package com.ecommerce.product.services;

import com.ecommerce.product.dtos.ProductRequest;
import com.ecommerce.product.dtos.ProductResponse;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    @Transactional
    public void createProduct(ProductRequest productRequest){
        Product newProduct = new Product();

        BeanUtils.copyProperties(productRequest, newProduct);

        productRepository.save(newProduct);

        log.info("Product created, id {} ", newProduct.getId());
    }
    @Transactional
    public ProductResponse getOneProductById(UUID id){
        Product foundProduct = productRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Product Found Exception"));

        ProductResponse foundProductResponse = new ProductResponse();
        BeanUtils.copyProperties(foundProduct, foundProductResponse);

        log.info("Product searched and founded, id {}", foundProductResponse.getId());
        return foundProductResponse;

    }

    @Transactional
    public List<ProductResponse> getAllProduct(){
        return productRepository.findAll().stream().map(this::mapToResponse).toList();
    }



    @Transactional
    public void deleteProductById(UUID id){
        productRepository.deleteById(id);

    }

    @Transactional
    public void updateProduct(UUID id, ProductRequest productRequest){
        Product foundProduct = productRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Product Found Exception"));

        BeanUtils.copyProperties(productRequest, foundProduct);

        productRepository.save(foundProduct);

        log.info("Product created, id {} ", foundProduct.getId());
        productRepository.deleteById(id);

    }

    private ProductResponse mapToResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }
}

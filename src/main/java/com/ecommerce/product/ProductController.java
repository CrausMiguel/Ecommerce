package com.ecommerce.product;

import com.ecommerce.product.dto.ProductRequest;
import com.ecommerce.product.dto.ProductResponse;
import com.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductResponse> createProduct(ProductRequest productRequest){
        ProductResponse productResponse = new ProductResponse();

        try{
            productService.createProduct(productRequest);

        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(productResponse);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productResponse);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@RequestParam UUID id){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(productService.getProduct(id));
    }

}

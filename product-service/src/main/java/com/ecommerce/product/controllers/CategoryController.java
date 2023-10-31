package com.ecommerce.product.controllers;

import com.ecommerce.product.dtos.CategoryRequest;
import com.ecommerce.product.dtos.CategoryResponse;
import com.ecommerce.product.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(
                categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<CategoryResponse> getOneCategory(@PathVariable UUID id) {

        return ResponseEntity.ok(categoryService.getOneCategoryById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCategory(@PathVariable UUID id, @RequestBody CategoryRequest updateCategory) {
        categoryService.updateCategory(id, updateCategory);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody CategoryRequest newCategory) {
        categoryService.createCategory(newCategory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategoryById(@PathVariable UUID id) {
        categoryService.deleteCategoryById(id);
    }
}

package com.ecommerce.product.services;


import com.ecommerce.product.dtos.CategoryRequest;
import com.ecommerce.product.dtos.CategoryResponse;
import com.ecommerce.product.model.Category;
import com.ecommerce.product.repositories.CategoryRepository;
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
public class CategoryService {

    private final CategoryRepository categoryRepository;
    @Transactional
    public void createCategory(CategoryRequest categoryRequest){
        Category newCategory = new Category();

        BeanUtils.copyProperties(categoryRequest, newCategory);

        categoryRepository.save(newCategory);

        log.info("Category created, id {} ", newCategory.getId());
    }
    @Transactional
    public CategoryResponse getOneCategoryById(UUID id){
        Category foundCategory = categoryRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Category Found Exception"));

        CategoryResponse foundCategoryResponse = new CategoryResponse();
        BeanUtils.copyProperties(foundCategory, foundCategoryResponse);

        log.info("Category searched and founded, id {}", foundCategoryResponse.getId());
        return foundCategoryResponse;

    }
    @Transactional
    public List<CategoryResponse> getAllCategory(){
        return categoryRepository.findAll().stream().map(this::mapToResponse).toList();
    }

 

    @Transactional
    public void deleteCategoryById(UUID id){
        categoryRepository.deleteById(id);

    }

    @Transactional
    public void updateCategory(UUID id, CategoryRequest categoryRequest){
        Category foundCategory = categoryRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Category Found Exception"));

        BeanUtils.copyProperties(categoryRequest, foundCategory);

        categoryRepository.save(foundCategory);

        log.info("Category created, id {} ", foundCategory.getId());
        categoryRepository.deleteById(id);

    }
    private CategoryResponse mapToResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        BeanUtils.copyProperties(category, categoryResponse);
        return categoryResponse;
    }
   


}

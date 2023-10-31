package com.ecommerce.product.repositories;

import com.ecommerce.product.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CategoryRepository extends MongoRepository<Category, UUID> {
}

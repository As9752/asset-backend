package com.kloudspot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kloudspot.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}

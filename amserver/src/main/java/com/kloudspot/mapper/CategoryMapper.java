package com.kloudspot.mapper;

import org.springframework.stereotype.Component;

import com.kloudspot.model.Category;
import com.kloudspot.model.record.CategoryRecord;

@Component
public class CategoryMapper {

	public Category convertToCategory(CategoryRecord categoryRecord) {
		Category category = new Category();
		category.setCategoryId(categoryRecord.categoryId());
		category.setName(categoryRecord.name());
		return category;
	}

	public CategoryRecord convertToCategoryRecord(Category category) {
		CategoryRecord categoryRecord = new CategoryRecord(category.getCategoryId(), category.getName());
		return categoryRecord;
	}
}

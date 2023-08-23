package com.kloudspot.service;

import java.util.List;

import com.kloudspot.exception.CategoryNotFoundException;
import com.kloudspot.model.record.CategoryRecord;

public interface ICategoryService {

	public List<CategoryRecord> getAllCategories();

	public CategoryRecord getCategoryById(String categoryId) throws CategoryNotFoundException;

	public CategoryRecord addCategory(CategoryRecord categoryRecord);

	public CategoryRecord updateCategory(String categoryId, CategoryRecord categoryRecord)
			throws CategoryNotFoundException;

	public void deleteCategory(String categoryId);

}

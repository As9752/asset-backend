package com.kloudspot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kloudspot.exception.CategoryNotFoundException;
import com.kloudspot.mapper.CategoryMapper;
import com.kloudspot.model.Category;
import com.kloudspot.model.record.CategoryRecord;
import com.kloudspot.repository.CategoryRepository;
import com.kloudspot.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<CategoryRecord> getAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		return convertCategoryList(categories);
	}

	@Override
	public CategoryRecord getCategoryById(String categoryId) throws CategoryNotFoundException {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new CategoryNotFoundException("Category with given id not found"));
		return categoryMapper.convertToCategoryRecord(category);
	}

	@Override
	public CategoryRecord addCategory(CategoryRecord categoryRecord) {
		Category categoryToAdd = categoryMapper.convertToCategory(categoryRecord);
		Category addedCategory = categoryRepository.insert(categoryToAdd);
		return categoryMapper.convertToCategoryRecord(addedCategory);
	}

	@Override
	public CategoryRecord updateCategory(String categoryId, CategoryRecord categoryRecord)
			throws CategoryNotFoundException {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new CategoryNotFoundException("Category with given id not found"));
		category.setName(categoryRecord.name());
		categoryRepository.save(category);
		return categoryMapper.convertToCategoryRecord(category);
	}

	@Override
	public void deleteCategory(String categoryId) {
		categoryRepository.deleteById(categoryId);

	}

	List<CategoryRecord> convertCategoryList(List<Category> categories) {
		return categories.stream().map((category) -> categoryMapper.convertToCategoryRecord(category)).toList();
	}

}

package com.kloudspot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kloudspot.exception.CategoryNotFoundException;
import com.kloudspot.model.record.CategoryRecord;
import com.kloudspot.service.ICategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<CategoryRecord>> getAllCategories() {
		return ResponseEntity.ok(categoryService.getAllCategories());
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryRecord> getCategoryById(@PathVariable String categoryId)
			throws CategoryNotFoundException {

		CategoryRecord categoryRecord = categoryService.getCategoryById(categoryId);
		return new ResponseEntity<>(categoryRecord, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<CategoryRecord> createCategory(@RequestBody CategoryRecord categoryRecord) {
		CategoryRecord addedCategoryRecord = categoryService.addCategory(categoryRecord);
		return new ResponseEntity<>(addedCategoryRecord, HttpStatus.CREATED);
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryRecord> updateCategory(@PathVariable String categoryId,
			@RequestBody CategoryRecord categoryRecord) throws CategoryNotFoundException {

		return new ResponseEntity<CategoryRecord>(categoryService.updateCategory(categoryId, categoryRecord),
				HttpStatus.OK);
	}

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Void> deleteCategory(@PathVariable String categoryId) {
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

package com.ikman.app.ikman.controllers;

import com.ikman.app.ikman.models.Category;
import com.ikman.app.ikman.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/all")
    public List<Category> showAllCategories(){
        return categoryService.getAllCategories();
    }
}

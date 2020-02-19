package com.ikman.app.ikman.service;

import com.ikman.app.ikman.models.Category;
import com.ikman.app.ikman.models.drafts.CategoryDraft;
import com.ikman.app.ikman.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryByDraft(CategoryDraft draft){
        Category category = categoryRepository.findCategoryByCategoryName(draft.getCategoryName());
        if(category == null || category.getId() <= 0){
            categoryRepository.save(new Category(draft.getCategoryName()));
        }
        return category;
    }

    public Category getCategoryByName(String name){
        return categoryRepository.findCategoryByCategoryName(name);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}

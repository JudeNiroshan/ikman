package com.ikman.app.ikman.repository;

import com.ikman.app.ikman.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findCategoryByCategoryName(String categoryName);

    @Override
    List<Category> findAll();
}

package com.ikman.app.ikman.repository;

import com.ikman.app.ikman.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query(value = "SELECT ca FROM Category ca WHERE ca.categoryName= ?1")
    Category findCategoryByName(String name);
}

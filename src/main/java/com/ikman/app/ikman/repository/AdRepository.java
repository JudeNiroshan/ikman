package com.ikman.app.ikman.repository;

import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdRepository extends CrudRepository<Ad, Long> {

    List<Ad> findByName(String name);

    @Override
    List<Ad> findAll();

    List<Ad> findByCategory(Category category);

    @Override
    <S extends Ad> Iterable<S> saveAll(Iterable<S> iterable);

}

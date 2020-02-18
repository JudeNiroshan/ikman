package com.ikman.app.ikman.repository;

import com.ikman.app.ikman.models.Ad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdRepository extends CrudRepository<Ad, Long> {

    List<Ad> findByName(String name);

    @Override
    List<Ad> findAll();

    @Query(value = "select a from Ad a, Category c where a.category=c.id and c.categoryName= ?1")
    List<Ad> findByCategory(String categoryName);

    @Override
    <S extends Ad> Iterable<S> saveAll(Iterable<S> iterable);

}

package com.ikman.app.ikman.repository;

import com.ikman.app.ikman.models.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {

    Image findByImageUrl(String s);
}

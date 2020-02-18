package com.ikman.app.ikman.repository;

import com.ikman.app.ikman.models.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {

    @Query(value = "SELECT lo FROM Location lo WHERE lo.locationName= ?1")
    Location findLocationByName(String name);
}

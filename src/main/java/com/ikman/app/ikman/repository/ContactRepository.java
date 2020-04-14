package com.ikman.app.ikman.repository;

import com.ikman.app.ikman.models.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    Contact findByContactNumber(String s);
}

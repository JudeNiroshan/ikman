package com.ikman.app.ikman.models;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
public class Contact implements Serializable {
    public Contact() {
    }

    public Contact(String contactNumber) {
        this.contactNumber=contactNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String contactNumber;
}

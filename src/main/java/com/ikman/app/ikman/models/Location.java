package com.ikman.app.ikman.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Location")
public class Location {
    public Location(String location) {
        this.name = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToMany(mappedBy="location")
    @Column(nullable = false)
    String name;
}

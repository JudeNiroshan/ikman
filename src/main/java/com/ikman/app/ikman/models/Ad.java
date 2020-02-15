package com.ikman.app.ikman.models;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ads")
@Getter
public class Ad {
    public Ad(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    String description;

    @CreationTimestamp
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    LocalDateTime created;

    @Column(nullable = false)
    String price;
}

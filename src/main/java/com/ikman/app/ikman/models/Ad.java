package com.ikman.app.ikman.models;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Ads")
@Getter
public class Ad {
    public Ad() {
    }

    public Ad(String name, String description, String price, Category category, Location location) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    Location location;

    @Column(nullable = false)
    String price;

    @CreationTimestamp
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    LocalDateTime created;

}

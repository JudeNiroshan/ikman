package com.ikman.app.ikman.models;

import lombok.Builder;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Ads")
@Getter
public class Ad implements Serializable {
    public Ad() {
    }

    public Ad(String name, String popUrl, String description, String price, Category category, Location location) {
        this.name = name;
        this.pop_url = popUrl;
        this.description = description;
        this.price = price;
        this.category = category;
        this.location = location;
    }

    public Ad(String name, String popUrl, String description, String price, Category category, Location location,
              Set<Image> images, Set<Contact> contacts) {
        this.name = name;
        this.pop_url = popUrl;
        this.description = description;
        this.price = price;
        this.category = category;
        this.location = location;
        this.images = images;
        this.contacts = contacts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String pop_url;

    String description;

    @OneToMany(cascade = CascadeType.MERGE)
    Set<Image> images;

    @OneToMany(cascade = CascadeType.MERGE)
    Set<Contact> contacts;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "categoryName")
    Category category;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "locationName")
    Location location;

    @Column(nullable = false)
    String price;

    @CreationTimestamp
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP")
    LocalDateTime created;

    @Column(nullable = false)
    String status = "pending";

}

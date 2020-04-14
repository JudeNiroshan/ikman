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
public class Image implements Serializable {
    public Image() {
    }

    public Image(String imageUrl) {
        this.imageUrl=imageUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String imageUrl;
}

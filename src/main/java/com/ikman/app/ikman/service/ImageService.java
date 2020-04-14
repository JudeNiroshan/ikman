package com.ikman.app.ikman.service;

import com.ikman.app.ikman.models.Image;
import com.ikman.app.ikman.models.drafts.ImageDraft;
import com.ikman.app.ikman.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image getImageByDraft(ImageDraft imageDraft) {
        Image existingImage = imageRepository.findByImageUrl(imageDraft.getImageUrl());
        if (existingImage == null) {
            return imageRepository.save(new Image(imageDraft.getImageUrl()));
        }

        return existingImage;
    }
}

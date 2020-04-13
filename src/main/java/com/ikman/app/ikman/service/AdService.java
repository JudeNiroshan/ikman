package com.ikman.app.ikman.service;

import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.models.Category;
import com.ikman.app.ikman.models.Contact;
import com.ikman.app.ikman.models.Image;
import com.ikman.app.ikman.models.Location;
import com.ikman.app.ikman.models.drafts.AdDraft;
import com.ikman.app.ikman.repository.AdRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdService {

    private final AdRepository adRepository;

    private final CategoryService categoryService;

    private final LocationService locationService;

    private final ImageService imageService;

    private final ContactService contactService;

    public AdService(AdRepository adRepository, CategoryService categoryService,
                     LocationService locationService, ImageService imageService, ContactService contactService) {
        this.adRepository = adRepository;
        this.categoryService = categoryService;
        this.locationService = locationService;
        this.imageService = imageService;
        this.contactService = contactService;
    }

    public Ad save(AdDraft adDraft) {

        Category category = categoryService.getCategoryByDraft(adDraft.getCategoryDraft());
        Location location = locationService.getLocationByDraft(adDraft.getLocationDraft());
        Ad ad;

        if (StringUtils.isNotBlank(adDraft.getStatus()) && !adDraft.getStatus().equalsIgnoreCase("pending")) {
            Set<Image> images = adDraft.getImageDrafts().stream()
                    .map(imageService::getImageByDraft)
                    .collect(Collectors.toSet());

            Set<Contact> contacts = adDraft.getContactDrafts().stream()
                    .map(contactService::getContactByDraft)
                    .collect(Collectors.toSet());
            ad = new Ad(adDraft.getName(), adDraft.getPopUrl(), adDraft.getDescription(), adDraft.getPrice(), category, location, images, contacts);
        }else {
            ad = new Ad(adDraft.getName(), adDraft.getPopUrl(), adDraft.getDescription(), adDraft.getPrice(), category, location);
        }
        return adRepository.save(ad);
    }

    public List<Ad> saveAll(List<AdDraft> adDrafts){
        return adDrafts.stream()
                .map(this::save)
                .collect(Collectors.toList());
    }

    public List<Ad> findByCategoryName(String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);
        return adRepository.findByCategory(category);
    }

    public void removeAdsBefore(LocalDateTime localDateTime) {
        adRepository.deleteAllByCreatedBefore(localDateTime);
    }

    public List<Ad> fetchPendingAds() {
        return adRepository.getAdsByStatusEquals("pending");
    }

    public List<Ad> findAll() {
        return adRepository.findAll();
    }
}

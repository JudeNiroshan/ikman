package com.ikman.app.ikman.service;

import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.models.Category;
import com.ikman.app.ikman.models.Location;
import com.ikman.app.ikman.models.drafts.AdDraft;
import com.ikman.app.ikman.repository.AdRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdService {

    private final AdRepository adRepository;

    private final CategoryService categoryService;

    private final LocationService locationService;

    public AdService(AdRepository adRepository, CategoryService categoryService, LocationService locationService) {
        this.adRepository = adRepository;
        this.categoryService = categoryService;
        this.locationService = locationService;
    }

    public Ad save(AdDraft adDraft) {

        Category category = categoryService.getCategoryByDraft(adDraft.getCategoryDraft());
        Location location = locationService.getLocationByDraft(adDraft.getLocationDraft());

        Ad ad = new Ad(adDraft.getName(), adDraft.getDescription(), adDraft.getPrice(), category, location);
        return adRepository.save(ad);
    }

    public List<Ad> findByCategoryName(String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);
        return adRepository.findByCategory(category);
    }

    public void removeAdsBefore(LocalDateTime localDateTime) {
        adRepository.deleteAllByCreatedBefore(localDateTime);
    }

    public List<Ad> findAll() {
        return adRepository.findAll();
    }
}

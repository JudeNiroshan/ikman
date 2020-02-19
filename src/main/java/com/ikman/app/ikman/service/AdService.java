package com.ikman.app.ikman.service;

import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.models.Category;
import com.ikman.app.ikman.models.Location;
import com.ikman.app.ikman.models.drafts.AdDraft;
import com.ikman.app.ikman.repository.AdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {

    private final AdRepository repository;

    private final CategoryService categoryService;

    private final LocationService locationService;

    public AdService(AdRepository repository, CategoryService categoryService, LocationService locationService) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.locationService = locationService;
    }

    public Ad save(AdDraft adDraft) {

        Category category = categoryService.getCategoryByDraft(adDraft.getCategoryDraft());
        Location location = locationService.getLocationByDraft(adDraft.getLocationDraft());

        Ad ad = new Ad(adDraft.getName(), adDraft.getDescription(), adDraft.getPrice(), category, location);
        return repository.save(ad);
    }

    public List<Ad> findByCategoryName(String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);
        return repository.findByCategory(category);
    }

    public List<Ad> findAll() {
        return repository.findAll();
    }
}

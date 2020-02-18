package com.ikman.app.ikman.controllers;

import com.ikman.app.ikman.init.IkmanFetcher;
import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.service.AdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdController {
    private final IkmanFetcher fetcher;

    private final AdService adService;

    public AdController(IkmanFetcher fetcher, AdService adService) {
        this.fetcher = fetcher;
        this.adService = adService;
    }

    @GetMapping("/health")
    public String health() {
        return "App is working";
    }

    @GetMapping("/ads/category/{categoryName}")
    public List<Ad> getByName(@PathVariable String categoryName) {
        return adService.findByCategoryName(categoryName);
    }

    @GetMapping("/ads")
    public List<Ad> allAds() {
        return adService.findAll();
    }
}

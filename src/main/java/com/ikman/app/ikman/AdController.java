package com.ikman.app.ikman;

import com.ikman.app.ikman.init.IkmanFetcher;
import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.repository.AdRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdController {
    private final AdRepository adRepository;
    private final IkmanFetcher fetcher;

    public AdController(AdRepository adRepository, IkmanFetcher fetcher) {
        this.adRepository = adRepository;
        this.fetcher = fetcher;
    }

    @GetMapping("/health")
    public String health() {
        return "App is working";
    }

    @GetMapping("/ads/category/{categoryName}")
    public Ad getByName(@PathVariable String categoryName) {
        return adRepository.findByName(categoryName).stream().findFirst().orElse(null);
    }

    @GetMapping("/ads")
    public List<Ad> allAds() {
        return adRepository.findAll();
    }
}

package com.ikman.app.ikman;

import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.repository.AdRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdController {
    final AdRepository adRepository;

    public AdController(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @GetMapping("/health")
    public String health() {
        return "App is working";
    }

    @GetMapping("/ads/{name}")
    public Ad getByName(@PathVariable String name) {
        return adRepository.findByName(name).stream().findFirst().orElse(new Ad());
    }

    @GetMapping("/ads")
    public List<Ad> allAds() {
        return adRepository.findAll();
    }
}

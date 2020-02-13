package com.ikman.app.ikman;

import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdController {
    @Autowired
    AdRepository adRepository;

    @GetMapping("/health")
    public String health(){
        return "App is working";
    }

    @GetMapping("/ad/{name}")
    public Ad getByName(String adName){
        return adRepository.findByName(adName).stream().findFirst().orElse(new Ad());
    }

    @GetMapping("/ads")
    public List<Ad> allAds(){
        return adRepository.findAll();
    }
}

package com.ikman.app.ikman.init;

import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.repository.AdRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DataInitializer {

    private final AdRepository adRepository;

    DataInitializer(IkmanFetcher ikmanFetcher, AdRepository adRepository) {
        this.adRepository = adRepository;
        try {
            List<Ad> allAdDrafts = ikmanFetcher.getAllAds();
            Iterable<Ad> saved = adRepository.saveAll(allAdDrafts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package com.ikman.app.ikman.init;

import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.repository.AdRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Service
public class DataInitializer {

    private final AdRepository adRepository;

    private final IkmanFetcher fetcher;

    DataInitializer(IkmanFetcher ikmanFetcher, AdRepository adRepository) {
        this.adRepository = adRepository;
        this.fetcher = ikmanFetcher;
    }

    @PostConstruct
    void loadDataFromExternalSystems(){
        try {
            List<Ad> allAdDrafts = fetcher.getAllAds();
            Iterable<Ad> saved = adRepository.saveAll(allAdDrafts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

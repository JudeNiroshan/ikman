package com.ikman.app.ikman.init;

import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.service.AdService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DataInitializer {

    private final AdService adService;

    private final IkmanFetcher fetcher;

    public DataInitializer(AdService adService, IkmanFetcher fetcher) {
        this.adService = adService;
        this.fetcher = fetcher;
    }

    @PostConstruct
    void loadDataFromExternalSystems(){
        try {
            Set<Ad> saved = fetcher.getAllAds().stream()
                    .map(adService::save)
                    .collect(Collectors.toSet());
            System.out.println("New ads===" + saved.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

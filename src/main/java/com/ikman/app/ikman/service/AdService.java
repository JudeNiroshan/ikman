package com.ikman.app.ikman.service;

import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.models.drafts.AdDraft;
import com.ikman.app.ikman.repository.AdRepository;
import org.springframework.stereotype.Service;

@Service
public class AdService {

    private final AdRepository repository;

    public AdService(AdRepository repository) {
        this.repository = repository;
    }

    public Ad createAd(AdDraft adDraft){

        Ad savedAd = repository.save(createAdBy(adDraft));
        return savedAd;
    }

    private Ad createAdBy(AdDraft adDraft){
//        new Ad(adDraft.ge)
        return null;
    }
}

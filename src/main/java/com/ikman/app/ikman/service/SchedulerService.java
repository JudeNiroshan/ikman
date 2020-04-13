package com.ikman.app.ikman.service;

import com.ikman.app.ikman.init.IkmanFetcher;
import com.ikman.app.ikman.models.Ad;
import com.ikman.app.ikman.models.drafts.AdDraft;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchedulerService {

    private final AdService adService;

    private final IkmanFetcher fetcher;

    public SchedulerService(AdService adService, IkmanFetcher fetcher) {
        this.adService = adService;
        this.fetcher = fetcher;
    }

    @Scheduled(cron = "0 0 0 ? * 1")
    public void deleteAdsOlderThanOneWeek() {
        System.out.println("cron is working" + LocalDateTime.now());
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1).truncatedTo(ChronoUnit.DAYS);
        adService.removeAdsBefore(oneWeekAgo);
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void processPendingAds() {
        List<AdDraft> adDrafts = new ArrayList<>();
        for (Ad ad : adService.fetchPendingAds()) {
            AdDraft adDraft = null;
            try {
                adDraft = fetcher.fetchDetails(AdDraft.getDraftByModel(ad));
                adDrafts.add(adDraft);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

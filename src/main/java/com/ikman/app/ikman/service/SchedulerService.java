package com.ikman.app.ikman.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class SchedulerService {

    private final AdService adService;

    public SchedulerService(AdService adService) {
        this.adService = adService;
    }

    @Scheduled(cron = "0 0 0 ? * 1")
    public void deleteAdsOlderThanOneWeek() {
        System.out.println("cron is working" + LocalDateTime.now());
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusWeeks(1).truncatedTo(ChronoUnit.DAYS);
        adService.removeAdsBefore(oneWeekAgo);
    }
}

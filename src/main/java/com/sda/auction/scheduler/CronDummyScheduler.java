package com.sda.auction.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
//@EnableScheduling
public class CronDummyScheduler {
    @Scheduled(cron = "0/30 * * * * *")
    public void scheduleTask(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Displaying message: " + now);
    }
}

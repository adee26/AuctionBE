package com.sda.auction;

import com.sda.auction.scheduler.CronDummyScheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AuctionApplication {

    public static void main(String[] args) { SpringApplication.run(AuctionApplication.class, args);

    }

}

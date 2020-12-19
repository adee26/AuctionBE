package com.sda.auction.controllers;

import com.sda.auction.services.BiddingService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiddingController {
    private final BiddingService biddingService;

    public BiddingController(BiddingService biddingService) {
        this.biddingService = biddingService;
    }
}

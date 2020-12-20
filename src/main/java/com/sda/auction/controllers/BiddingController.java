package com.sda.auction.controllers;

import com.sda.auction.services.BiddingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BiddingController {
    private final BiddingService biddingService;

}

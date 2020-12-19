package com.sda.auction.controllers;

import com.sda.auction.services.PurchasingService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchasingController {
    private final PurchasingService purchasingService;

    public PurchasingController(PurchasingService purchasingService) {
        this.purchasingService = purchasingService;
    }
}

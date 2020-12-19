package com.sda.auction.services;

import com.sda.auction.repositories.PurchasingRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchasingServiceImpl implements PurchasingService {
    private final PurchasingRepository purchasingRepository;

    public PurchasingServiceImpl(PurchasingRepository purchasingRepository) {
        this.purchasingRepository = purchasingRepository;
    }
}

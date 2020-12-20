package com.sda.auction.services;

import com.sda.auction.repositories.BiddingRepository;
import org.springframework.stereotype.Service;

@Service
public class BiddingServiceImpl implements BiddingService {
    private final BiddingRepository biddingRepository;

    public BiddingServiceImpl(BiddingRepository biddingRepository) {
        this.biddingRepository = biddingRepository;
    }
}

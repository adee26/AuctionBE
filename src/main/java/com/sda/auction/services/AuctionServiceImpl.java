package com.sda.auction.services;

import com.sda.auction.repositories.AuctionRepository;
import org.springframework.stereotype.Service;

@Service
public class AuctionServiceImpl implements AuctionService {
    private final AuctionRepository auctionRepository;

    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }
}

package com.sda.auction.services;

import com.sda.auction.repositories.AuctionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuctionServiceImpl implements AuctionService {
    private final AuctionRepository auctionRepository;

}

package com.sda.auction.services;

import com.sda.auction.repositories.BiddingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BiddingServiceImpl implements BiddingService {
    private final BiddingRepository biddingRepository;

}

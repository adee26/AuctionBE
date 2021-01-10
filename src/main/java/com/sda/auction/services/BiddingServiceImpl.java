package com.sda.auction.services;

import com.sda.auction.entitites.Bidding;
import com.sda.auction.repositories.BiddingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BiddingServiceImpl implements BiddingService {
    private final BiddingRepository biddingRepository;

    @Override
    public void createBidding(Bidding bidding) {
        biddingRepository.save(bidding);
    }

    @Override
    public List<Bidding> findAllBiddings() {
        return biddingRepository.findAll();
    }

    @Override
    public Optional<Bidding> findById(int id) {
        return biddingRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        biddingRepository.deleteById(id);
    }

    @Override
    public List<Bidding> findBiddingByUserId(int id) {
        return biddingRepository.findAllByUserId(id);
    }

}

package com.sda.auction.services;

import com.sda.auction.DTO.BidDTO;
import com.sda.auction.entitites.Bidding;

import java.util.List;
import java.util.Optional;

public interface BiddingService {

    void createBidding(Bidding bidding);
    List<Bidding> findAllBiddings();
    Optional<Bidding> findById(int id);
    void deleteById(int id);
    List<Bidding> findBiddingByUserId(int id);
    void placeBid(int auctionId, BidDTO bidDTO) throws Exception;
    Bidding updateBidding(int biddingId, Bidding bidding) throws Exception;
}

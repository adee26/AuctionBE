package com.sda.auction.services;

import com.sda.auction.entitites.Auction;

import java.util.List;
import java.util.Optional;

public interface AuctionService {

    Auction createAuction(Auction auction);
    List<Auction> findAllAuctions();
    Optional<Auction> findById(int id);
    void deleteById(int id);
    Auction updateAuction(Auction auction, int id) throws Exception;
}

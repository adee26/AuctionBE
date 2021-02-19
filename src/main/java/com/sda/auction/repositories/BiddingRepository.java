package com.sda.auction.repositories;

import com.sda.auction.entitites.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BiddingRepository extends JpaRepository<Bidding, Integer> {
    List<Bidding> findAllByUserId(int userId);
    Optional<Bidding> findBiddingByAuctionId(int auctionId);
}

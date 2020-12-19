package com.sda.auction.repositories;

import com.sda.auction.entitites.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiddingRepository extends JpaRepository<Bidding, Integer> {
}

package com.sda.auction.repositories;

import com.sda.auction.entitites.Purchasing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasingRepository extends JpaRepository<Purchasing, Integer> {
}

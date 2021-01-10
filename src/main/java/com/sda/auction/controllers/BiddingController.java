package com.sda.auction.controllers;

import com.sda.auction.entitites.Bidding;
import com.sda.auction.services.BiddingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bidding")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BiddingController {
    private final BiddingService biddingService;

    @GetMapping("/{id}")
    public List<Bidding> findBiddingByUserId(@PathVariable("id") int id){
        return biddingService.findBiddingByUserId(id);
    }
}

package com.sda.auction.controllers;

import com.sda.auction.DTO.BidDTO;
import com.sda.auction.entitites.Bidding;
import com.sda.auction.services.BiddingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BiddingController {
    private final BiddingService biddingService;

    @GetMapping("api/v1/bidding")
    public List<Bidding> findBiddingByUserId(@PathVariable("id") int id){
        return biddingService.findBiddingByUserId(id);
    }

    @PostMapping ("api/v1/auction/{auctionId}")
    public void placeBid(@PathVariable("auctionId") int auctionId, @RequestBody BidDTO bidDTO) throws Exception {
        biddingService.placeBid(auctionId, bidDTO);
    }
}

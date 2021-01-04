package com.sda.auction.controllers;
import com.sda.auction.entitites.Auction;
import com.sda.auction.services.AuctionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auction")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuctionController {
    private final AuctionService auctionService;

    @GetMapping("/{id}")
    public Optional<Auction> findAuctionById(@PathVariable int id){
        return auctionService.findById(id);
    }

    @GetMapping()
    public List<Auction> findAllAuctions(){
        return auctionService.findAllAuctions();
    }

    @PostMapping()
    public void saveAuction(@RequestBody Auction auction){
        auctionService.createAuction(auction);
    }

    @PutMapping()
    public Auction editAuction(@RequestBody Auction auction, @PathVariable int id) throws Exception {
        return auctionService.updateAuction(auction, id);
    }

    @DeleteMapping()
    public void deleteAuction(@RequestBody Auction auction) {
        auctionService.deleteById(auction.getId());
    }

}

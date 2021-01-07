package com.sda.auction.controllers;
import com.sda.auction.entitites.Auction;
import com.sda.auction.services.AuctionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @PutMapping("/{id}")
    public Auction editAuction(@RequestBody Auction auction, @PathVariable int id) throws Exception {
        return auctionService.updateAuction(auction, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAuction(@PathVariable("id") int id){
        auctionService.deleteById(id);
    }

    @GetMapping("/recently")
    public List<Auction> findFourRecentlyAddedAuctions(){
        return auctionService.findAllAuctions()
                .stream()
                .sorted(Comparator.comparing(Auction::getStartDate).reversed())
                .limit(4)
                .collect(Collectors.toList());
    }

    @GetMapping("/ending")
    public List<Auction> findFourEndingAuctions(){
        return auctionService.findAllAuctions()
                .stream()
                .sorted(Comparator.comparing(Auction::getEndDate))
                .filter(auction -> auction.getEndDate().isAfter(LocalDateTime.ofInstant(Instant.now(),  ZoneId.of("Europe/Bucharest"))))
                .limit(4)
                .collect(Collectors.toList());
    }

    @GetMapping("/recentlyEnded")
    public List<Auction> findFourRecentlyEndedAuctions(){
        return this.auctionService.findAllAuctions()
                .stream()
                .sorted(Comparator.comparing(Auction::getEndDate).reversed())
                .filter(auction -> auction.getEndDate().isBefore(LocalDateTime.ofInstant(Instant.now(),  ZoneId.of("Europe/Bucharest"))))
                .limit(4)
                .collect(Collectors.toList());
    }
}

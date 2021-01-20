package com.sda.auction.services;

import com.sda.auction.entitites.Auction;
import com.sda.auction.repositories.AuctionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuctionServiceImpl implements AuctionService {
    private static final int AUCTION_DAYS = 7;
    private final AuctionRepository auctionRepository;

    @Override
    public Auction createAuction(Auction auction) {
        auction.setStartDate(LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Bucharest")));
        auction.setEndDate(LocalDateTime.ofInstant(Instant.now().plus(AUCTION_DAYS, ChronoUnit.DAYS), ZoneId.of("Europe/Bucharest")));
        return auctionRepository.save(auction);
    }

    @Override
    public List<Auction> findAllAuctions() {
        return auctionRepository.findAll();
    }

    @Override
    public Optional<Auction> findById(int id) {
        return auctionRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        auctionRepository.deleteById(id);
    }

    @Override
    public Auction updateAuction(Auction auction, int id) throws Exception{
        try{
            Optional<Auction> newAuction = Optional.ofNullable(auction);
            Auction oldAuction = auctionRepository.findById(id)
                    .orElseThrow(()->new Exception("Auction not found!"));
            oldAuction.setTitle(newAuction.map(Auction::getTitle).orElse(oldAuction.getTitle()));
            oldAuction.setDescription(newAuction.map(Auction::getDescription).orElse(oldAuction.getDescription()));
            oldAuction.setPhotos(newAuction.map(Auction::getPhotos).orElse(oldAuction.getPhotos()));
            oldAuction.setMinimumPrice(newAuction.map(Auction::getMinimumPrice).orElse(oldAuction.getMinimumPrice()));
            oldAuction.setBuyNowPrice(newAuction.map(Auction::getBuyNowPrice).orElse(oldAuction.getBuyNowPrice()));
            oldAuction.setStartDate(newAuction.map(Auction::getStartDate).orElse(oldAuction.getStartDate()));
            oldAuction.setEndDate(newAuction.map(Auction::getEndDate).orElse(oldAuction.getEndDate()));

            return auctionRepository.save(auction);
        }catch (Exception e){
            throw new RuntimeException("Auction not found.");
        }
    }

}

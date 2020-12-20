package com.sda.auction.services;

import com.sda.auction.entitites.Auction;
import com.sda.auction.repositories.AuctionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuctionServiceImpl implements AuctionService {
    private final AuctionRepository auctionRepository;

    @Override
    public Auction createAuction(Auction auction) {
        auction.setStartDate(LocalDateTime.from(Instant.now()));
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
        Optional<Auction> auctionOptional = auctionRepository.findById(id);
        if(auctionOptional.isPresent()){
            auctionOptional.get().setTitle(auction.getTitle());
            auctionOptional.get().setDescription(auction.getDescription());
            auctionOptional.get().setPhotos(auction.getPhotos());
            auctionOptional.get().setMinimumPrice(auction.getMinimumPrice());
            auctionOptional.get().setBuyNowPrice(auction.getBuyNowPrice());
            auctionOptional.get().setStartDate(auction.getStartDate());
            auctionOptional.get().setEndDate(auction.getEndDate());
            return auctionRepository.save(auctionOptional.get());
        }else {
            throw new Exception("Auction not found");
        }
    }

}

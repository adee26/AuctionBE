package com.sda.auction.services;

import com.sda.auction.DTO.BidDTO;
import com.sda.auction.entitites.Auction;
import com.sda.auction.entitites.Bidding;
import com.sda.auction.entitites.User;
import com.sda.auction.repositories.AuctionRepository;
import com.sda.auction.repositories.BiddingRepository;
import com.sda.auction.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BiddingServiceImpl implements BiddingService {
    private final BiddingRepository biddingRepository;
    private final AuctionService auctionService;
    private final UserService userService;

    @Override
    public void createBidding(Bidding bidding) {
        biddingRepository.save(bidding);
    }

    @Override
    public List<Bidding> findAllBiddings() {
        return biddingRepository.findAll();
    }

    @Override
    public Optional<Bidding> findById(int id) {
        return biddingRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        biddingRepository.deleteById(id);
    }

    @Override
    public List<Bidding> findBiddingByUserId(int id) {
        return biddingRepository.findAllByUserId(id);
    }

    @Override
    public void placeBid(int auctionId, BidDTO bidDTO) throws Exception {
        Optional<Auction> auction = auctionService.findById(auctionId);
        Optional<User> user = userService.findById(bidDTO.getUserId());
        List<Bidding> userBiddingList = user.get().getBiddingList();

        if(auction.isPresent() && user.isPresent()){
            if(auction.get().getMinimumPrice() < bidDTO.getBid()){
                Bidding bidding = new Bidding();

                bidding.setUser(user.get());
                bidding.setAuction(auction.get());
                biddingRepository.save(bidding);
                userBiddingList.add(bidding);

                auction.get().setMinimumPrice(bidDTO.getBid());
                auctionService.updateAuction(auction.get(), auctionId);

                userService.updateUser(user.get(), bidDTO.getUserId());
            }
        }
    }

    @Override
    public Bidding updateBidding(int biddingId, Bidding bidding) throws Exception {
        Optional<Bidding> oldBidding = biddingRepository.findById(biddingId);
        if(oldBidding.isPresent()){
            oldBidding.get().setUser(bidding.getUser());
            return   biddingRepository.save(oldBidding.get());
        }
        throw new Exception("Bidding not found");
    }

}

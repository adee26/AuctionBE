package com.sda.auction.entitites;

import lombok.*;

import javax.persistence.*;

@Entity(name = "bidding")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bidding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "auction_id")
    private Auction auction;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

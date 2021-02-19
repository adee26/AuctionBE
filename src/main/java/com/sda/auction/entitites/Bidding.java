package com.sda.auction.entitites;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private int bid;

    @ManyToOne
    @JoinColumn (name = "auction_id")
    @ToString.Exclude
    private Auction auction;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}

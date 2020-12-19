package com.sda.auction.entitites;

import lombok.*;

import javax.persistence.*;

@Entity(name = "purchasing")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchasing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;
}

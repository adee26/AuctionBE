package com.sda.auction.entitites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String photos;
    private int minimumPrice;
    private int buyNowPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany (mappedBy = "auction")
    private List<Bidding> biddingList;

    @OneToOne (mappedBy = "auction")
    private Purchasing purchasing;

    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;
}

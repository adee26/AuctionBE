package com.sda.auction.entitites;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    private List<Auction> auctionList;
}

package com.sda.auction.entitites;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private String Address;

    @OneToOne
    @JoinColumn (name = "user_id")
    private User user;

    @OneToMany (mappedBy = "auction")
    private List<Bidding> biddingList;

    @OneToOne (mappedBy = "auction")
    private Purchasing purchasing;

    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;
}

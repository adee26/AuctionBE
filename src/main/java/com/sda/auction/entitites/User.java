package com.sda.auction.entitites;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String name;
    private Date creationDate;
    private String accountType;

    @OneToOne(mappedBy = "user")
    private Address address;

    @OneToMany (mappedBy = "user")
    private List<Bidding> biddingList;

    @OneToMany(mappedBy = "user")
    private List<Purchasing> purchasingList;
}

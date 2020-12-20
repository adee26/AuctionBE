package com.sda.auction.entitites;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String name;
    @Column(updatable = false)
    private Date creationDate;
    private String accountType;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany (mappedBy = "user")
    private List<Bidding> biddingList;

    @OneToMany(mappedBy = "user")
    private List<Purchasing> purchasingList;
}

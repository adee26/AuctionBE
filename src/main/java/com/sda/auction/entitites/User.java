package com.sda.auction.entitites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sda.auction.entitites.enums.UserRole;
import lombok.*;

import javax.persistence.*;
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
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private Address address;

    @OneToMany (mappedBy = "user")
    @ToString.Exclude
    private List<Bidding> biddingList;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Purchasing> purchasingList;
}

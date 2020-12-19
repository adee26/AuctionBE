package com.sda.auction.entitites;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @ToString.Exclude
    @OneToOne
    @JoinColumn (name = "user_id")
    private User user;
}

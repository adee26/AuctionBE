package com.sda.auction.entitites;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "auction")
@Data
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
    @Column(name = "buy_now")
    private int buyNowPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "auction")
    @JsonIgnore
    @ToString.Exclude
    private List<Bidding> biddingList;

    @OneToOne(mappedBy = "auction")
    @JsonIgnore
    @ToString.Exclude
    private Purchasing purchasing;


    @ManyToOne
    @JoinColumn(name = "category_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty(value = "categoryId")
    private Category category;
}

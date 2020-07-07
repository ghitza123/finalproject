package com.finalProject.auction.entities;
import javax.persistence.*;

@Entity
@Table(name = "bid")

public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bidId")
    private int bidId;

    @Column(name = "bidValue")
    private String title;

}

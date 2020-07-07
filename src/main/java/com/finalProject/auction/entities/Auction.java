package com.finalProject.auction.entities;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auction")

public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auctionId")
    private int auctionId;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    public Auction() {
    }
}

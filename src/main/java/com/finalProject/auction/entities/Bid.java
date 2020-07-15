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
    private int bidValue;

    @ManyToOne
    @JoinColumn(name = "auctionId")
    private Auction biddedAuction;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userWithTheBid;


    public Bid() {
    }

    public Bid(int value) {
        this.bidValue = value;
    }
}

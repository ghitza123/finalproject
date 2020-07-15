package com.finalProject.auction.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchaseId")
    private int purchaseId;

    @Column(name = "bidValue")
    private int bidValue;

    @OneToOne
    @JoinColumn(name = "auctionId")
    private Auction purchasedAuctionItem;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userThatPurchased;

    public Purchase() {
    }

    public Purchase(int bidValue) {
        this.bidValue = bidValue;
    }
}

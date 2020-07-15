package com.finalProject.auction.entities;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "auction")

public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auctionId")
    private int auctionId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @OneToMany(fetch = FetchType.EAGER,mappedBy =  "biddedAuction")
    private List<Bid> auctionBidList;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category auctionCategory;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "purchasedAuctionItem")
    private Purchase purchase;
//
//    @OneToOne
//    @JoinColumn(name = "statusId")
//    private Status statusOfTheauction;




    public Auction() {
    }

    public Auction(String auctionTitle, String description) {
        this.title = auctionTitle;
        this.description = description;
        this.startDate = LocalDateTime.now();
    }

    public Auction(String auctionTitle) {
        this.title = auctionTitle;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public String getTitle() {
        return title;
    }

    public List<Bid> getAuctionBidList() {
        return auctionBidList;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuctionBidList(List<Bid> auctionBidList) {
        this.auctionBidList = auctionBidList;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auctionId=" + auctionId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", auctionBidList=" + auctionBidList +
                ", auctionCategory=" + auctionCategory +
                ", purchase=" + purchase +
                '}';
    }
}

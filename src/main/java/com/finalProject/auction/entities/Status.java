package com.finalProject.auction.entities;

import javax.persistence.*;


@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusId")
    private int statusId;

    @OneToOne
    private Auction auctionShownInStatus;


    @OneToOne
    @JoinColumn(name = "userId")
    private User userFromTheStatus;

    public Status() {
    }

}

package com.finalProject.auction.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "userName")
    private String userName;

    @OneToMany(mappedBy= "userWithTheBid")
    private List<Bid> bidsOfTheUser;

    @OneToMany(mappedBy= "userThatPurchased")
    private List<Purchase> purchasesOfTheUser;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }


}

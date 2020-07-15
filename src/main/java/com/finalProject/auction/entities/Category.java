package com.finalProject.auction.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private int categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    @OneToMany(mappedBy = "auctionCategory")
    private List<Auction> auctionsWithTheCategory;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }


}

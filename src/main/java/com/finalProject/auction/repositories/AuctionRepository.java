package com.finalProject.auction.repositories;

import com.finalProject.auction.entities.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction,Integer> {

    Auction getByAuctionId (Integer auctionId);

    List<Auction> findAllByAuctionIdGreaterThanOrderByAuctionIdDesc (Integer auctionId);

    List<Auction> findAllByAuctionIdGreaterThanOrderByAuctionId (Integer startingId);

    void deleteAuctionByTitle(String auctionTitle);

}

package com.finalProject.auction.repositories;

import com.finalProject.auction.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid,Integer> {

}

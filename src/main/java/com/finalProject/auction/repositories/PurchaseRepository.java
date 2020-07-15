package com.finalProject.auction.repositories;

import com.finalProject.auction.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {

}

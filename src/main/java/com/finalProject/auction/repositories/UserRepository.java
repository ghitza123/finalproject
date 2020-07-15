package com.finalProject.auction.repositories;

import com.finalProject.auction.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}

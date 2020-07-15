package com.finalProject.auction;

import com.finalProject.auction.repositories.AuctionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AuctionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(AuctionApplication.class, args);

AuctionRepository auctionRepository = run.getBean(AuctionRepository.class);
		System.out.println(auctionRepository.getByAuctionId(1));


	}

}

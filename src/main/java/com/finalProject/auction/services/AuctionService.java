package com.finalProject.auction.services;

import com.finalProject.auction.dto.AuctionDTO;
import com.finalProject.auction.entities.Auction;
import com.finalProject.auction.repositories.AuctionRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuctionService {
    @Autowired
    AuctionRepository auctionRepository;

    //get all auctions
    public List<AuctionDTO> getAuctions(){
        List<Auction> all = auctionRepository.findAll();

        return convertToDTOs(all);
    }
//Get all auctions by parameters
    public List<AuctionDTO> getAuctionsByParams(String order, Integer startingId){

        if(startingId == null || startingId < 0){
            startingId = 0;
        }

        List<Auction> auctions;

        if("desc".equals(order)){
            auctions = auctionRepository.
                   findAllByAuctionIdGreaterThanOrderByAuctionIdDesc(startingId);
            return convertToDTOs(auctions);
        }

        auctions = auctionRepository.
                findAllByAuctionIdGreaterThanOrderByAuctionId(startingId);

        return convertToDTOs(auctions);
    }
//convert to data transfer object
    private List<AuctionDTO> convertToDTOs(List<Auction> auctions){
        List<AuctionDTO> auctionDTOS = new ArrayList<>();

        for(Auction a: auctions){
            auctionDTOS.add(new AuctionDTO(a.getAuctionId(),a.getTitle(),a.getDescription()));
        }

        return auctionDTOS;
    }

    @Transactional
    public void deleteByTitle(String auctionTitle){
        auctionRepository.deleteAuctionByTitle(auctionTitle);

    }
}

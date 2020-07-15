package com.finalProject.auction.controllers;

import com.finalProject.auction.dto.AuctionDTO;
import com.finalProject.auction.entities.Auction;
import com.finalProject.auction.repositories.AuctionRepository;
import com.finalProject.auction.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AuctionController {

    String myData = "omfg fomg";

    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    AuctionService auctionService;

    @GetMapping(value = "/auctions")
    public ResponseEntity<List<AuctionDTO>> auctionList1(
            @RequestParam(name = "order", required = false) String order,
            @RequestParam(name = "idGreaterThan", required = false) Integer idGreaterThan) {

        List<AuctionDTO> dtos = auctionService.getAuctionsByParams(order,idGreaterThan);

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
//post that creates new auctions
    @PostMapping(value = "/auctions/newAuctions")
    public ResponseEntity<List<Auction>> postAuctions(@RequestBody List<AuctionDTO> auctions){

        List<Auction> auctionEntityList = new ArrayList<>();

        for(AuctionDTO adto: auctions){
            auctionEntityList.add(new Auction(adto.getTitle(),adto.getDescription()));
        }

        auctionRepository.saveAll(auctionEntityList);

        return new ResponseEntity<>(auctionEntityList, HttpStatus.ACCEPTED);

    }
    //delete an auction
    @DeleteMapping(value = "auctions/{auctionTitle}")
    public ResponseEntity deleteAuctionByTitle (@PathVariable String auctionTitle) {
        auctionService.deleteByTitle(auctionTitle);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/auctions/list")
    public ResponseEntity<List<AuctionDTO>> auctionList() {
        List<AuctionDTO> auctions = auctionService.getAuctions();

        return new ResponseEntity<>(auctions, HttpStatus.OK);
    }



    @GetMapping(value = "/auctions/{auctionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuctionDTO> auctions(@PathVariable Integer auctionId) {
        Optional<Auction> myAuction = auctionRepository.findById(auctionId);

        if(!myAuction.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Auction auctionFromOptional = myAuction.get();

        AuctionDTO dto = new AuctionDTO(
                auctionFromOptional.getAuctionId(), auctionFromOptional.getTitle(),auctionFromOptional.getDescription());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    //helpfull examples
    @PostMapping(value = "/printAuction",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void printAuctionMethod(@RequestBody AuctionDTO auctionDTO){
        System.out.println(auctionDTO);
    }

    @PostMapping("/createHere")
    public void methodToRecieveData(@RequestBody String dataFromRequest){
        System.out.println("we got this data: "+  dataFromRequest);
    }

    @GetMapping("/someData")
    public ResponseEntity<String> someData(){
        String ourData = "some data from the controller";

        return new ResponseEntity<>(myData + ourData, HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/someData2")
    public ResponseEntity<String> someData2(){
        String ourData = "this is another data";

        return new ResponseEntity<>(myData + ourData, HttpStatus.BAD_GATEWAY);
    }


}

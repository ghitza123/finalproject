package com.finalProject.auction.dto;

import java.time.LocalDateTime;


public class AuctionDTO {
Integer auctionId;
String title;
String description;
LocalDateTime startDate;
LocalDateTime endDate;
LocalDateTime currentDate;

    public AuctionDTO() {
    }

    public AuctionDTO(Integer auctionId, String title, String description) {
        this.auctionId = auctionId;
        this.title = title;
        this.description = description;
        this.currentDate = LocalDateTime.now();
    }

    public AuctionDTO(Integer auctionId, String title, String description, LocalDateTime startDate) {
        this.auctionId = auctionId;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.currentDate = LocalDateTime.now();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "AuctionDTO{" +
                "auctionId=" + auctionId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", currentDate=" + currentDate +
                '}';
    }
}

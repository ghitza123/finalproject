create table bid
(
    bidId int auto_increment,
    auctionId int null,
    userId int null,
    bidValue int not null,
    PRIMARY KEY (bidId),
    FOREIGN KEY (auctionId) REFERENCES auction(auctionId),
    FOREIGN KEY (userId) REFERENCES user(userId)
);
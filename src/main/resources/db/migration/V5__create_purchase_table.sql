create table purchase
(
    purchaseId int auto_increment,
    auctionId int null,
    userId int null,
    bidValue int not null,
    PRIMARY KEY (purchaseId),
    FOREIGN KEY (auctionId) REFERENCES auction(auctionId),
    FOREIGN KEY (userId) REFERENCES user(userId)
);
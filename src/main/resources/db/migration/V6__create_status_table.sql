create table status
(
    statusId int auto_increment,
    auctionId int null,
    userId int null,
    PRIMARY KEY (statusId),
    FOREIGN KEY (auctionId) REFERENCES auction(auctionId),
    FOREIGN KEY (userID) REFERENCES user(userId)
)
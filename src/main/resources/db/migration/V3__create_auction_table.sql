create table auction
(
    auctionId int auto_increment,
    title varchar(78) not null,
    description varchar(255) null,
    startDate datetime,
    endDate datetime,
    categoryId int null,
#     purchaseId int null,
    PRIMARY KEY (auctionId),
    FOREIGN KEY (categoryId) REFERENCES category(categoryId)
#     FOREIGN KEY (purchaseId) REFERENCES purchase(purchaseId)

);
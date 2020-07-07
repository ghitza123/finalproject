create table auction
(
    auctionId int auto_increment,
    title varchar(78) not null,
    category varchar(28) not null,
    description varchar(255) null,
    startDate datetime,
    endDate datetime,
    PRIMARY KEY (auctionId)

);
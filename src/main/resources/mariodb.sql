DROP DATABASE IF EXISTS mariodb;
CREATE DATABASE mariodb;
USE mariodb;

CREATE TABLE User (
    id VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    coins INT,
    language VARCHAR(50),
    points INT,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE Item (
    id VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(300),
    price INT NOT NULL,
    type VARCHAR(100),
    damage INT,
    dmgReduction INT,
    avatar VARCHAR(50),
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE Inventory (
    id VARCHAR(50) NOT NULL,
    userId VARCHAR(50) NOT NULL,
    itemId VARCHAR(50) NOT NULL,
    FOREIGN KEY (userId) REFERENCES User(id),
    FOREIGN KEY (itemId) REFERENCES Item(id)
) ENGINE = InnoDB;

CREATE TABLE FAQ (
    question VARCHAR(500),
    ans VARCHAR(500)
) ENGINE = InnoDB;

CREATE TABLE GAME (
    id VARCHAR(50) NOT NULL,
    userId VARCHAR(50) NOT NULL,
    finished TINYINT(1),
    points INT,
    coins INT
) ENGINE = InnoDB;

CREATE TABLE ISSUE (
    date VARCHAR(50),
    informer VARCHAR(50),
    message VARCHAR(500)
) ENGINE = InnoDB;

CREATE TABLE Question (
    date VARCHAR(50),
    title VARCHAR(50),
    message VARCHAR(500),
    sender VARCHAR(50)
) ENGINE = InnoDB;

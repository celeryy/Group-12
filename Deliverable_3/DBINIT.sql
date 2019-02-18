-- Assumes that the database is already created with name 'TripleCrown"
-- use TripleCrown

CREATE TABLE IF NOT EXISTS raceday (
    _name VARCHAR(255) PRIMARY KEY,
    _date DATE,
    track VARCHAR(255),
    _events VARCHAR(255)
);

-- Participants? A: multi-valued, a list of all horseIDs participating in each particular race. 
CREATE TABLE IF NOT EXISTS race (
    RaceID INT PRIMARY KEY,
    track VARCHAR(255),
    distance INT,
    prizewon VARCHAR(255),
    gates INT,
    participants VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS track (
    _name VARCHAR(255) PRIMARY KEY,
    location VARCHAR(255),
    length INT,
    terraintype VARCHAR(255)
);

-- colors is also a multi-valued attribute
CREATE TABLE IF NOT EXISTS jockey (
    jockeyID INT PRIMARY KEY,
    _name VARCHAR(255),
    colors VARCHAR(255),
    height INT,
    weight INT,
    _rank INT,
    earnings INT
);

CREATE TABLE IF NOT EXISTS _owner (
    ownerID INT PRIMARY KEY,
    _name VARCHAR(255),
    networth INT,
    _rank INT
);

CREATE TABLE IF NOT EXISTS trainer (
    trainerID INT PRIMARY KEY,
    name VARCHAR(255),
    _rank INT,
    earnings INT

);

CREATE TABLE IF NOT EXISTS record (
    Totalraces INT,
    Raceswon INT,
    Winpercent INT
);

CREATE TABLE IF NOT EXISTS prize (
    Trophytitle VARCHAR(255),
    Cashvaluegiven INT
);

CREATE TABLE IF NOT EXISTS horse (
    horseID INT PRIMARY KEY,
    _name VARCHAR(255),
    height INT,
    weight INT,
    _value VARCHAR(255),
    age INT,
    breed VARCHAR(255),
    ownerID INT,
    jockeyID INT,
    trainerID INT,
    FOREIGN KEY (ownerID) REFERENCES _owner (ownerID),
    FOREIGN KEY (jockeyID) REFERENCES jockey (jockeyID),
    FOREIGN KEY (trainerID) REFERENCES trainer (trainerID)
);

CREATE TABLE IF NOT EXISTS winner (
    raceID INT PRIMARY KEY,
    completiontime INT,
    horseID INT,
    ownerID INT,
    trainerID INT,
    jockeyID INT,
    prizewon VARCHAR(255),
    FOREIGN KEY (ownerID) REFERENCES _owner (ownerID),
    FOREIGN KEY (jockeyID) REFERENCES jockey (jockeyID),
    FOREIGN KEY (trainerID) REFERENCES trainer (trainerID),
    FOREIGN KEY (horseID) REFERENCES horse (horseID),
    FOREIGN KEY (raceID) REFERENCES race (raceID)
);

INSERT INTO raceday (_name, _date, track, _events)
VALUES ('kentucky derby ultimate', '20200310', 'lucky 13', 'raceiD 1'),
 ('super 8', '20200325', 'roundabout', 'raceiD 2'),
 ('long stretch', '20200415', 'straight track', 'raceiD 3');

INSERT INTO race (raceID, track, distance, prizewon, gates, participants)
VALUES ('230', 'lucky_13', '30', 'trophy', '3', 'edward'),
('231', 'roundabout', '60', 'money', '4', 'suzy'),
('232', 'straight track', '100', 'trophy and money', '5', 'nathan');

INSERT INTO track (_name, location, length, terraintype)
VALUES ('lucky 13', 'kentucky', '30', 'dirt'),
('roundabout', 'virginia', '60', 'grass'),
('straight track', 'minnesota', '100', 'dirt');

INSERT INTO jockey (jockeyID, _name, colors, height, weight, _rank, earnings)
VALUES ('567', 'elizabeth', 'orange', '56', '150', '2', '5000'),
('568', 'nathan', 'black', '58', '155', '1', '10000'),
('569', 'roger', 'red', '511', '165', '3', '3000');

INSERT INTO _owner (ownerID, _name, networth, _rank)
VALUES ('4567', 'stacy', '10000', '1'),
('4568', 'elizabeth', '5000', '2'),
('4569', 'nathan', '3000', '3');

INSERT INTO trainer (trainerID, _name, _rank, earnings)
VALUES ('568', 'joshua', '1', '10000'),
('569', 'rebecca', '2', '5000'),
('570', 'janet', '3', '3000');

INSERT INTO horse (horseID, _name, height, weight, _value, age, breed, ownerID, jockeyID, trainerID)
VALUES ('3', 'adonis', '411', '300', '1', '5', 'black', '4567', '567', '568'),
('4', 'hercules', '52', '400', '2', '4', 'brown', '4568', '568', '569'),
('5', 'leonard', '49', '355', '3', '7', 'white', '4569', '569', '570');

INSERT INTO record (Totalraces, Raceswon, Winpercent)
VALUES ('3', '2', '90'),
('4', '1', '25'),
('5', '3', '60');

INSERT INTO winner (raceID, completiontime, horseID, ownerID, trainerID, jockeyID, prizewon)
VALUES ('230', '10', '3', '4567', '568', '567', 'money'),
('231', '15', '4', '4568', '569', '568', 'money'),
('232', '8', '5', '4569', '570', '569', 'money');

INSERT INTO prize (trophytitle, cashvaluegiven)
VALUES ('derby ultimate', '3000'),
('roundabout champion', '5000'),
('fastest straight track', '10000');

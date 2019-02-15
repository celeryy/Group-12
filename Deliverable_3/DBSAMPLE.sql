SELECT * FROM record;

SELECT * FROM track;

SELECT horseID  FROM horse;

SELECT cashvaluegiven FROM prize
WHERE cashvaluegiven >= 5000;

SELECT prizewon FROM winner;

SELECT _name FROM trainer
WHERE trainerID=569;

SELECT ownerID FROM _owner
WHERE _name='nathan';

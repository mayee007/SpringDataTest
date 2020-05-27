CREATE TABLE IF NOT EXISTS  fullname(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50), 
    lastName VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS  TECHNOLOGY(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    technologyType VARCHAR(50), 
    category VARCHAR(50)
);

create table  IF NOT EXISTS  PROBLEM (
	id smallint unsigned not null auto_increment, 
	problem longtext,
	reasonForProblem longtext,
	solution longtext,
	submitDate date, 
	modifiedDate date,
	technology smallint unsigned not null references TECHNOLOGY(id) ,
	primary key(id) 
);

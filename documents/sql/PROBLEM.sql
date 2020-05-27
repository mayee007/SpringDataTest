create table PROBLEM (
	id smallint unsigned not null auto_increment, 
	problem longtext,
	reasonForProblem longtext,
	solution longtext,
	submitDate date, 
	modifiedDate date,
	technology smallint unsigned not null references TECHNOLOGY(id) ,
	primary key(id) 
)

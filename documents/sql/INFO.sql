create table INFO (
	id smallint unsigned not null auto_increment, 
	subject char(200) not null,
	description longtext,
	submitDate date, 
	modifiedDate date,
	technology smallint unsigned not null references TECHNOLOGY(id) ,
	primary key(id) 
)

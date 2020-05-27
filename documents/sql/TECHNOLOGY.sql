CREATE TABLE `TECHNOLOGY` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `technologyType` char(100) DEFAULT NULL,
  `category` char(100) DEFAULT NULL,
  PRIMARY KEY (id) ,
  UNIQUE (technologyType, category)
)

insert into TECHNOLOGY (technologytype,category) values ('Java','Hibernate')
insert into TECHNOLOGY (technologytype,category) values ('Java','Spring')
insert into TECHNOLOGY (technologytype,category) values ('Java','EJB3')
insert into TECHNOLOGY (technologytype,category) values ('Java','Database')
insert into TECHNOLOGY (technologytype,category) values ('Java','WebServices')

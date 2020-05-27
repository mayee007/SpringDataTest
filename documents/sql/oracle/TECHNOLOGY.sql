CREATE TABLE TECHNOLOGY (
  id int NOT NULL,
  technologyType char(100) DEFAULT NULL,
  category char(100) DEFAULT NULL,
  PRIMARY KEY (id) ,
  UNIQUE (technologyType, category)
);

create sequence technology_seq start with 1 increment by 1 nomaxvalue; 
create trigger technology_seq_trigger before insert on test for each row begin select test_seq.nextval into :new.id from dual; end; 

create trigger technology_seq_trigger 
before insert on technology 
for each row 
begin 
select technology_seq.nextval into :new.id from dual; 
end;
/

insert into TECHNOLOGY (technologytype,category) values ('Java','Hibernate');
insert into TECHNOLOGY (technologytype,category) values ('Java','Spring');
insert into TECHNOLOGY (technologytype,category) values ('Java','EJB3');
insert into TECHNOLOGY (technologytype,category) values ('Java','Database');
insert into TECHNOLOGY (technologytype,category) values ('Java','WebServices');

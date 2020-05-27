CREATE TABLE INFOUSER (
  id int NOT NULL ,
  userName varchar(255) DEFAULT NULL,
  age int DEFAULT NULL,
  registered int DEFAULT NULL,
  PRIMARY KEY (id)
);

create sequence infouser_seq start with 1 increment by 1 nomaxvalue; 

create trigger infouser_seq_trigger 
before insert on infouser 
for each row 
begin 
select infouser_seq.nextval into :new.id from dual; 
end;
/

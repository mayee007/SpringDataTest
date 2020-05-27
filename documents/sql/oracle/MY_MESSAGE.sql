CREATE TABLE MY_MESSAGE (
  id int NOT NULL,
  submitdate date NOT NULL,
  message varchar(1024) NOT NULL,
  PRIMARY KEY (id)
); 

create sequence my_message_seq start with 1 increment by 1 nomaxvalue; 

create trigger my_message_seq_trigger 
before insert on my_message 
for each row 
begin 
select my_message_seq.nextval into :new.id from dual; 
end;
/
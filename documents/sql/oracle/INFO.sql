create table INFO (
	id smallint not null, 
	subject char(200) not null,
	description clob,
	submitDate date, 
	modifiedDate date,
	technology smallint not null references TECHNOLOGY(id) ,
	primary key(id) 
);

create sequence info_seq start with 1 increment by 1 nomaxvalue; 

create trigger info_seq_trigger 
before insert on info 
for each row 
begin 
select info_seq.nextval into :new.id from dual; 
end;
/

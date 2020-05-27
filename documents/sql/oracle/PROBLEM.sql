create table PROBLEM (
	id int not null, 
	problem clob,
	reasonForProblem clob,
	solution clob,
	submitDate date, 
	modifiedDate date,
	technology smallint not null references TECHNOLOGY(id) ,
	primary key(id) 
);

create sequence problem_seq start with 1 increment by 1 nomaxvalue; 

create trigger problem_seq_trigger 
before insert on PROBLEM 
for each row 
begin 
select problem_seq.nextval into :new.id from dual; 
end;
/

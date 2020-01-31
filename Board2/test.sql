create table board(
	num number(6) primary key,
	author varchar2(15) not null,
	title varchar2(90) not null,
	content varchar2(1000) not null,
	writeday date default sysdate,
	readcnt number(6) default 0,
	repRoot number(4),
	repStep number(4),
	repIndent number(4)
)


select * from BOARD

-- DML study-------------------------------------------------------------------------------

select * from zoo
select replace(reg_date, '.000', '') kk   from zoo
select substr('아리랑테스트', 3, 2) 
select substr('아리랑테스트', -3, 2)
select substr(name,2,1) || '*' || substr(name,3,1) from zoo
select concat(substr(name,2,1),'*',substr(name,3,1))  from zoo

select round(3.64)
select ceil(3.14)
select floor(3.64)
select truncate(3.64, 0)


select now()
select now(), sysdate(), current_timestamp
select datetime()


-- DDL -------------------------------------------------------------------------------
-- 테이블 생성
-- column name, data type, null|not null, default value, comment
create table test 
(
	id int not null auto_increment comment '아이디',
	name varchar(100) default null comment '이름',
	age int default null comment '나이',
	chg_date datetime default current_timestamp comment '변경일',
	primary key(id)
)

create table zoo (
	id int(11) not null auto_increment comment 'seq id',
	species varchar(100) not null default 'any' comment '종',
	gender varchar(1) not null default 'M' comment '성별',
	name varchar(100) null default null comment '이름',
	age int(4) null default null comment '나이',
	reg_date datetime not null default current_timestamp comment '등록 날짜', 
	chg_date datetime not null default current_timestamp comment '변경 날짜',
	
	constraint zoo_pk primary key(id) comment '동물원'
)


-- alter
alter table zoo
add reg_date datetime not null default current_timestamp comment '등록 날짜',
add chg_date datetime not null default current_timestamp comment '변경 날짜'

alter table zoo
-- rename to zoo_park
-- drop column detail
-- change column test detail varchar(10)
-- modify test int(10)
-- add test varchar(1)
	
commit

-- 테이블 삭제
drop table product
drop table zoo
drop table zoo_park 

rollback


-- 테이블 삽입
insert into zoo(species, gender, name, age) values ('dog', 'W','sam', 11);
insert into zoo(species, gender, name, age) values ('dog', 'M','bob', 8);

insert into test() values ()

-- 테이블 수정
update test 
set name='bbb' 
where id=1

-- 테이블 조회
select * from zoo
select * from product
select * from board

SELECT 1 FROM dual

desc product 
desc board 

select chg_date  from zoo
select date_format(chg_date, '%Y-%m-%d %H:%i:%s')  from zoo

-- delete
delete from zoo 
where id = 2;

-- 
rollback;
commit;

select now()
select now(), sysdate(), current_timestamp
select datetime()




create table board (
	id int(11) not null auto_increment comment 'seq id',
	title varchar(100) not null comment '제목',
	content varchar(1000) null comment '내용',
	name varchar(100) not null comment '작성자',
	hit int(11) null default 0 comment '읽은수',
	reg_date datetime not null default current_timestamp comment '등록 날짜', 
	chg_date datetime not null default current_timestamp comment '변경 날짜',
	
	constraint board_pk primary key(id) comment '게시판'
)

insert into board 
(title, content, name)
values 
('제목3', '내용3', '이름3')

select * from board

commit






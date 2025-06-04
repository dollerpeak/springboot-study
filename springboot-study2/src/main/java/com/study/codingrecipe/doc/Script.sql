-- root정보
server host : localhost
port : 3306
database : 공란
username : root
password : atdata.1!!

-- database
show databases

create database aroundhub
drop database aroundhub
create database springstudy

-- user
select * from mysql.user 
where user = 'atdata'

create user 'atdata'@'%' identified by 'atdata.1!!' -- 모두 접속가능
create user 'atdata'@'local' identified by 'atdata.1!!' -- db가 설치된 서버에서만 접속 가능
create user 'atdata'@'127.0.0.1' identified by 'atdata.1!!' -- 특정 IP에서 접속 가능
drop user 'atdata'@'%' -- user 삭제
drop user 'atdata'@'local'
drop user 'atdata'@'127.0.0.1'
alter user 'atdata'@'%' identified by 'atdata.1!!' -- 패스워드 변경

-- 권한부여
show grants for 'atdata'@'%'

grant all privileges on aroundhub.* to 'atdata'@'%' -- database 전체권한
grant all privileges on aroundhub.tablename to 'atdata'@'%' -- database.tablename 전체권한
grant select privileges on aroundhub.tablename to 'atdata'@'%' -- database.tablename select권한

grant all privileges on springstudy.* to 'atdata'@'%' -- database 전체권한

-- 권한회수
revoke delete on aroundhub.* from 'atdata'@'%'

-- 
flush privileges

-- 
commit

=====================================================================================================
=====================================================================================================

create table board 
(
	seq int not null auto_increment comment 'seq',
	title varchar(100) not null comment '제목',
	contents varchar(500) not null comment '내용',
	writer varchar(20) not null comment '작성자',
	password varchar(20) not null comment '비밀번호',
	hits int not null default 0 comment '조회수',
	frst_reg_date datetime not null default current_timestamp comment '최초등록일',
	frst_reg_user_id varchar(20) not null default 'SYSTEM' comment '최초등록자',
	last_chg_date datetime not null default current_timestamp comment '변경등록일',
	last_chg_user_id varchar(20) not null default 'SYSTEM' comment '변경등록자',
	primary key(seq)
)

drop table board

alter table board change id seq int

commit

=====================================================================================================
=====================================================================================================


select current_timestamp()

select * from board

-- delete from board 
where seq > 2






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




-- root정보
root / atdata.1!!

-- database
show databases
create database erpapp
drop database aroundhub

-- user
select * from mysql.user 
create user 'atdata'@'%' identified by 'atdata.1!!' -- 모두 접속가능
create user 'atdata'@'local' identified by 'atdata.1!!' -- db가 설치된 서버에서만 접속 가능
create user 'atdata'@'127.0.0.1' identified by 'atdata.1!!' -- 특정 IP에서 접속 가능
drop user 'atdata'@'%' -- user 삭제
drop user 'atdata'@'local'
drop user 'atdata'@'127.0.0.1'
alter user 'atdata'@'%' identified by 'atdata.1!!' -- 패스워드 변경

-- 권한부여
grant all privileges on erpapp.* to 'atdata'@'%' -- database 전체권한
grant all privileges on erpapp.tablename to 'atdata'@'%' -- database.tablename 전체권한
grant select privileges on aroundhub.tablename to 'atdata'@'%' -- database.tablename select권한


-- 
flush privileges

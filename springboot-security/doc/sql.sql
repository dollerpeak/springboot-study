
use springstudy

===========================================================================================

-- drop table user
CREATE TABLE `user` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(20) NOT NULL COMMENT '이름',
  `password` VARCHAR(100) NOT NULL COMMENT '비밀번호',
  `role` VARCHAR(20) NOT NULL COMMENT '역할',
  `frst_reg_date` DATETIME NOT NULL DEFAULT current_timestamp() COMMENT '최초등록일',
  `frst_reg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` DATETIME NOT NULL DEFAULT current_timestamp() COMMENT '변경등록일',
  `last_chg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into user (name, password, role) values ('id', 'pw', 'role')


CREATE TABLE `category` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(20) NOT NULL COMMENT '카테고리명',
  `frst_reg_date` DATETIME NOT NULL DEFAULT current_timestamp() COMMENT '최초등록일',
  `frst_reg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` DATETIME NOT NULL DEFAULT current_timestamp() COMMENT '변경등록일',
  `last_chg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into category (name) values ('패션'); 
insert into category (name) values ('뷰티');
insert into category (name) values ('식품');
insert into category (name) values ('디지털');


CREATE TABLE `product` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(20) NOT NULL COMMENT '제품명',
  `price` INT unsigned NOT NULL COMMENT '가격',
  `frst_reg_date` DATETIME NOT NULL DEFAULT current_timestamp() COMMENT '최초등록일',
  `frst_reg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` DATETIME NOT NULL DEFAULT current_timestamp() COMMENT '변경등록일',
  `last_chg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



===========================================================================================

commit

select * from category

select * from user
name	password
1		1
2		$2a$10$4dk1SUzwtu8DZQY3JgSeTuNuFX9aLaGJhKmGzkLY1S4f9HEXRX/a.
3		{noop}3

-- delete from user
where 1=1
and name = '5'






















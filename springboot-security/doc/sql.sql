
use springstudy

===========================================================================================

-- drop table user
CREATE TABLE `user` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `email` VARCHAR(100) NOT NULL COMMENT '이메일',
  `name` VARCHAR(20) NOT NULL COMMENT '이름',
  `password` VARCHAR(100) NOT NULL COMMENT '비밀번호',
  `role` VARCHAR(20) NOT NULL COMMENT '역할',
  `frst_reg_date` DATETIME(0) NOT NULL DEFAULT current_timestamp() COMMENT '최초등록일',
  `frst_reg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` DATETIME(0) NOT NULL DEFAULT current_timestamp() COMMENT '변경등록일',
  `last_chg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='사용자 테이블';


-- drop table category
CREATE TABLE `category` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(20) NOT NULL COMMENT '카테고리명',
  `frst_reg_date` DATETIME(0) NOT NULL DEFAULT current_timestamp() COMMENT '최초등록일',
  `frst_reg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` DATETIME(0) NOT NULL DEFAULT current_timestamp() COMMENT '변경등록일',
  `last_chg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='상품 카테고리 테이블';

insert into category (name) values ('패션'); 
insert into category (name) values ('뷰티');
insert into category (name) values ('식품');
insert into category (name) values ('디지털');

-- drop table product
CREATE TABLE `product` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` INT NOT NULL COMMENT 'user id',
  `category_id` INT unsigned NOT NULL COMMENT '카테고리 id',
  `sold` BOOLEAN NOT NULL DEFAULT TRUE COMMENT '판매여부',
  `name` VARCHAR(20) NOT NULL COMMENT '제품명',
  `price` INT unsigned NOT NULL COMMENT '가격',
  `view_count` INT DEFAULT 0 COMMENT '조회수',
  `sell_count` INT DEFAULT 0 COMMENT '판매수',
  `desc` VARCHAR(500) COMMENT '설명',
  `thumbnail_url` VARCHAR(500) NOT NULL COMMENT '썸네일 url',  
  `frst_reg_date` DATETIME(0) NOT NULL DEFAULT current_timestamp() COMMENT '최초등록일',
  `frst_reg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` DATETIME(0) NOT NULL DEFAULT current_timestamp() COMMENT '변경등록일',
  `last_chg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='상품 테이블';

-- drop table product_detail_image
CREATE TABLE `product_detail_image` (
    `id` INT unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
    `product_id` INT NOT NULL COMMENT 'product id',
    `sort_order` INT DEFAULT 0 COMMENT '상세이미지 순서',
    `image_url` VARCHAR(500) NOT NULL COMMENT '상세 url',	
	`frst_reg_date` DATETIME(0) NOT NULL DEFAULT current_timestamp() COMMENT '최초등록일',
	`frst_reg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
	`last_chg_date` DATETIME(0) NOT NULL DEFAULT current_timestamp() COMMENT '변경등록일',
	`last_chg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='상품 상세이미지 테이블';

===========================================================================================

commit

select * from category

select * from product

select * from product_detail_image 

select * from user

delete from user
where 1=1
and name = '444'






















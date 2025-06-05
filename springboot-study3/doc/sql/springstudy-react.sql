
use springstudy

===========================================================================================

CREATE TABLE `blog` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
  `title` VARCHAR(255) NOT NULL COMMENT '제목',
  `writer` VARCHAR(255) NOT NULL COMMENT '작성자',
  `contents` TEXT DEFAULT NULL COMMENT '내용',
  `attach_count` INT NOT NULL DEFAULT 0 COMMENT '조회수',
  `frst_reg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '최초등록일',
  `frst_reg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '변경등록일',
  `last_chg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT '게시글 테이블'

CREATE TABLE `attach` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
  `blog_id` BIGINT UNSIGNED NOT NULL COMMENT 'blog id',
  `original_name` VARCHAR(255) NOT NULL COMMENT '원본이름',
  `save_name` VARCHAR(255) NOT NULL COMMENT '저장이름',
  `path` VARCHAR(255) NOT NULL COMMENT '경로',
  `size` VARCHAR(255) NOT NULL COMMENT '용량',
  `frst_reg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '최초등록일',
  `frst_reg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '변경등록일',
  `last_chg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT '첨부파일 테이블'


CREATE TABLE `comment` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
  `blog_id` BIGINT UNSIGNED NOT NULL COMMENT 'blog id',
  `writer` VARCHAR(100) NOT NULL COMMENT '작성자',
  `contents` TEXT DEFAULT NULL COMMENT '내용',
  `frst_reg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '최초등록일',
  `frst_reg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '변경등록일',
  `last_chg_user_id` VARCHAR(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자'
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT '댓글 테이블'


-- alter
alter table zoo
add reg_date datetime not null default current_timestamp comment '등록 날짜',
add chg_date datetime not null default current_timestamp comment '변경 날짜'

-- drop
-- drop table attach


===========================================================================================

insert into blog (title, writer, contents) values ("제목1", "작성자1", "내용1")
insert into blog (title, writer, contents) values ("제목2", "작성자2", "내용2")
insert into blog (title, writer, contents) values ("제목3", "작성자3", "내용3")


===========================================================================================

commit

select * from blog

select * from attach

select * from comment 

-- delete from attach 
where 1=1
and blog_id < 12
















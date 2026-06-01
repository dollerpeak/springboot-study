
use erpapp

===========================================================================================

-- 공통 그룹 코드 테이블 (CGC로 시작하는 10자리)
CREATE TABLE COMMON_GROUP_CODE (
    CODE          		VARCHAR(10)   NOT NULL COMMENT '그룹코드 (CG00000001)',
    NAME          		VARCHAR(100)  NOT NULL COMMENT '그룹코드명 (ex: 부서, 직급)',
    REMARK          	VARCHAR(500)           COMMENT '그룹코드 설명',
    USE_YN              CHAR(1)       DEFAULT 'Y' COMMENT '사용여부 (Y/N)',
    FIRST_REG_DATE      DATETIME(0)   NOT NULL COMMENT '최초등록일 (yyyy-mm-dd hh:mm:ss)',
    FIRST_REG_USER_ID   VARCHAR(100)  NOT NULL COMMENT '최초등록자ID',
    LAST_CHG_DATE       DATETIME(0)   NOT NULL COMMENT '최종변경일 (yyyy-mm-dd hh:mm:ss)',
    LAST_CHG_USER_ID    VARCHAR(100)  NOT NULL COMMENT '최종변경자ID',
    PRIMARY KEY (CODE)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='공통 그룹 코드';

-- 공통 상세 코드 테이블 (순수 PK만 지정)
CREATE TABLE COMMON_CODE (
    GROUP_CODE          VARCHAR(10)   NOT NULL COMMENT '그룹코드 (COMMON_GROUP_CODE.CODE 매핑)',
    CODE                VARCHAR(10)   NOT NULL COMMENT '상세코드 (CC00000001)',
    NAME                VARCHAR(100)  NOT NULL COMMENT '상세코드명 (ex: 인사팀, 과장)',
    SORT_ORDER          INT           DEFAULT 0 COMMENT '정렬순서',
    USE_YN              CHAR(1)       DEFAULT 'Y' COMMENT '사용여부 (Y/N)',
    FIRST_REG_DATE      DATETIME(0)   NOT NULL COMMENT '최초등록일 (yyyy-mm-dd hh:mm:ss)',
    FIRST_REG_USER_ID   VARCHAR(100)  NOT NULL COMMENT '최초등록자ID',
    LAST_CHG_DATE       DATETIME(0)   NOT NULL COMMENT '최종변경일 (yyyy-mm-dd hh:mm:ss)',
    LAST_CHG_USER_ID    VARCHAR(100)  NOT NULL COMMENT '최종변경자ID',
    PRIMARY KEY (GROUP_CODE, CODE) -- 복합 PK 자체로 완벽한 인덱스 역할 수행
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='공통 코드';


ALTER TABLE COMMON_GROUP_CODE CHANGE GROUP_DESC REMARK VARCHAR(500) COMMENT '그룹코드 설명'
drop table COMMON_CODE


commit

===========================================================================================

delete from common_group_code
select * from common_group_code 
insert into COMMON_GROUP_CODE(CODE, NAME, REMARK, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000001', '근무위치', '근무위치 코드', 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_GROUP_CODE(CODE, NAME, REMARK, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000002', '업무부서', '업무부서 코드', 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_GROUP_CODE(CODE, NAME, REMARK, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000003', '직급', '직급 코드', 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');


delete from common_code
select * from common_code 
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000001', 'CC00000001', '서울', 1, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000001', 'CC00000002', '분당', 2, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000002', 'CC00000001', '경영팀', 1, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000002', 'CC00000002', '인사팀', 2, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000002', 'CC00000003', '개발1팀', 3, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000003', 'CC00000001', '사장', 1, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000003', 'CC00000002', '부사장', 2, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000003', 'CC00000003', '부장', 3, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000003', 'CC00000004', '차장', 4, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000003', 'CC00000005', '과장', 5, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000003', 'CC00000006', '대리', 6, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');
insert into COMMON_CODE(GROUP_CODE, CODE, NAME, SORT_ORDER, USE_YN, FIRST_REG_DATE, FIRST_REG_USER_ID, LAST_CHG_DATE, LAST_CHG_USER_ID)
values('CG00000003', 'CC00000007', '사원', 7, 'Y', now(0), 'SYSTEM', now(0), 'SYSTEM');

select * from common_code
where  1=1
-- and GROUP_CODE  = 'CG00000002'
ORDER BY GROUP_CODE, CODE, SORT_ORDER ASC

















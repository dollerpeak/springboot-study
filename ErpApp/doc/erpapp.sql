
use erpapp

===========================================================================================

-- 공통 그룹 코드 테이블 (CGC로 시작하는 10자리)
CREATE TABLE COMMON_GROUP_CODE (
    CODE          		VARCHAR(10)   NOT NULL COMMENT '그룹코드 (CGC0000001)',
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

select * from common_group_code 
select * from common_code






















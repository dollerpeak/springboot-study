# 카네스블랙 카페

 자바 기반 풀스택 개발자 양성과정의 개인 프로젝트입니다.

- **프로젝트 기간**: 2024.10.10 ~ 2024.10.13
- **개발자**: 블랙강사 (개인프로젝트)

## 목차
1. [프로젝트 개요](#1-프로젝트-개요)
2. [프로젝트 구성](#2-프로젝트-구성)
3. [프로젝트 수행과정 및 결과](#3-프로젝트-수행과정-및-결과)
4. [프로젝트 후기](#4-프로젝트-후기)

## 1. 프로젝트 개요

### 프로젝트 필요성
- 기본적인 게시판 CRUD 구현
- 스프링 시큐리티를 통한 인증 및 인가 과정 구현
- XSS 공격 방지, CSRF 방지 등 기본적인 보안 처리 해결방법 제시

### 서비스 대상
블랙강사의 수업을 듣고자 하는 학생들

### 담당 업무
- Spring Security 구현
- API 설계
- DB 설계
- 프로젝트 환경 구성
- 게시판(CRUD) 개발
- 로그인/로그아웃 및 회원가입 기능 구현

## 2. 프로젝트 구성

### 기술 스택

| 구분 | 기술 |
|------|------|
| OS | Windows |
| Server | Amazon AWS |
| Database | MySQL |
| Testing | Swagger |
| Frontend | HTML5, CSS3, JavaScript |
| Backend | Spring Boot (v3.3.3), Java (OpenJDK-23) |
| IDE | Visual Studio Code, Eclipse |
| Collaboration | GitHub, Notion |

### 시스템 아키텍처

#### 시퀀스 다이어그램


#### 데이터베이스 구조
![image](https://github.com/user-attachments/assets/5122e7ed-4b13-49b1-810c-f8dc096329eb)


#### API 설계
![Screenshot_1](https://github.com/user-attachments/assets/67ef5db9-4046-4ff9-8911-31e8ebbc2a82)



## API 명세서

| Method | Endpoint | 설명 |
|--------|----------|------|
| DELETE | /menu/delete/{idx} | 메뉴 삭제 |
| GET | /menu/{idx} | 메뉴 상세 조회 |
| GET | /menu/all | 전체 메뉴 조회 |
| POST | /menu/add | 메뉴 추가 |
| PUT | /menu/update/{idx} | 메뉴 수정 |
| PUT | /menu/count/{idx} | 조회수 증가 |


## 3. 프로젝트 수행과정 및 결과

- 수행과정: 개인프로젝트임 개발기간 1일소요.
- 결과: 칭찬할만한점: ~~ 개선해야할점: JWT토큰추가제안,댓글기능추가

## 4. 프로젝트 후기
- ~~ 앞으로여 여러분이 팀프로젝트 어떤부분에 어떤식으로 커뮤니케이션을 진행할것인지 이번기회에 배웠다.(개선될방안)



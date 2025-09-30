# 1주차 백엔드 스터디 정리

## 클라이언트 - 서버

클라이언트 (Client): 요청을 보내고, 서버의 응답 결과를 받아 사용

서버(Server): 클라이언트의 요청을 받아 처리하고, 그에 대한 응답을 반환

URL: 웹 상에서 특정 자원의 위치를 나타내는 주소

## HTTP

 HTTP: 웹에서 데이터를 주고받는 서버-클라이언트 모델의 프로토콜

무상태성: 서버는 클라이언트의 이전 요청을 저장하지 않고, 매 요청을 독립적으로 처리

비연결성: 클라이언트가 요청을 보내고 응답을 받은 후 서버와 연결을 유지하지 않음

### HTTP 매서드

GET: 리소스를 조회 
ex) 게시글 읽기, 상품 목록 조회

POST: 리소스를 추가, 등록 
ex) 유저 정보 추가

PUT: 리소스를 교체, 없으면 새로 생성

PATCH: 리소스의 일부를 수정
ex) 게시글 제목 혹은 내용 수정

DELETE: 리소스를 삭제

### HTTP 주요 상태 코드

200 OK: 요청이 성공적으로 처리

201 Created: 요청이 성공적으로 처리되어 새로운 리소스 생성

400 Bad Request: "클라이언트"의 요청이 잘못되어 서버가 이해하지 못함

404 NOT Found: 지정한 리소스를 찾을 수 없음

500 Internal Server Error: 서버 내부 오류로 요청을 처리할 수 없음

## 프론트엔드와 백엔드

프론트엔드: 사용자가 직접 보고 상호작용하는 화면, UI를 개발

백엔드: 사용자의 요청을 받아 실제 동작을 처리하고 데이터를 저장, 관리

데이터베이스: 데이터를 체계적으로 모아둔 장소

## API와 REST API

API: 한 프로그램이 다른 프로그램의 기능이나 데이터를 사용할 수 있도록 미리 정해놓은 약속(규칙)이자 소통 창구

### REST

REST는 네트워크 아키텍쳐 스타일로, HTTP의 장점을 최댛나 활용할 수 있는 아키텍처.

1. 자원 - URI

2. 행위 - METHOD  
HTTP Method를 사용

3. 표현  
서버와 클라이언트가 데이터를 주고 받는 형식으로 JSON 형식이 일반적



## API 설계

### 상품 기능

상품 정보 등록

HTTP Method : POST

URI : /products

\
상품 목록 조회

HTTP Method : GET

URI : /products

\
개별 상품 정보 상세 조회

HTTP Method : GET

URI : /products/{productID}

\
상품 정보 수정

HTTP Method : PATCH

URI : /products/{productID}

\
상품 삭제

HTTP Method : DELETE

URI : /products/{productID}

### 주문 기능

주문 정보 생성

HTTP Method : POST

URI : /orders

\
주문 목록 조회

HTTP Method : GET

URI : /orders

\
개별 주문 정보 상세 조회

HTTP Method : GET

URI : /orders/{orderID}

\
주문 취소

HTTP Method : DELETE

URI : /orders/{orderID}

## 과제 스크린샷


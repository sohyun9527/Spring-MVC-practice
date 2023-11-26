# HTTP 요청 데이터 - 개요

- HTTP 요청 메세지를 통해 클라이언트 -> 서버 데이터 전달 방법은 크게 3가지이다.

## GET - 쿼리 파라미터

- `/url?username=hello&age=20`
- 메세지 바디 없이, URL 의 쿼리 파라미터에 데이터를 포함해서 전달한다.
- 예) 검색, 필터, 페이징 등에서 많이 사용하는 방식.

## POST - HTML Form

- `content-type: application/x-www-form-urlencoded`
- 메세지 바디에 쿼리 파라미터 형식으로 전달한다 `username=hello&age=20`
- 예) 회원 가입, 상품 주문, HTML Form 사용

## HTTP message body 내부에 데이터를 직접 담아서 요청

- HTTP API 에서 주로 사용한다. JSON, XML, TEXT
- 데이터 형식은 주로 JSON 을 사용한다.
- POST, PUT, PATCH
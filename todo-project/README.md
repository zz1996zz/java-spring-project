# TodoList-Project

## 프로젝트 목적
  * 백엔드 학습을 위한 Spring, JPA, REST API를 활용한 간단한 TodoList 어플리케이션 만들기  
  * MVC패턴을 활용합니다.
  
## 프로젝트에 대해서
  * Front-End
    - 백엔드 학습을 위해 만든 간단한 프로젝트이기 때문에 따로 구현하지 않았습니다.
    - 클라이언트에서 작동하는지 확인하기 위해 [Todo-Backend](https://www.todobackend.com/)에서 확인하였습니다.
  * Back-End
    - 프로젝트는 gradle프로젝트로 생성하였습니다.
    - 데이터베이스는 인 메모리 관계형 데이터 베이스인 h2데이터베이스를 사용하였습니다.
    - API를 테스트하기 위해 Postman프로그램을 사용하였습니다.

## 프로젝트 기능들
  1. todo 리스트 목록에 항목을 추가
  2. todo 리스트 목록 중 특정 항목을 조회
  3. todo 리스트 전체 목록을 조회
  4. todo 리스트 목록 중 특정 항목을 수정
  5. todo 리스트 목록 중 특정 항목을 삭제
  6. todo 리스트 전체 목록을 삭제

## API 스펙
|method|endpoint|기능|request|response|
|:---:|:---:|:---:|---|---|
|POST|/|todo 항목 추가|{<br>&nbsp;&nbsp;&nbsp;"title" : "자료구조 공부하기"<br>}|{<br>&nbsp;&nbsp;&nbsp;"id":17,<br>&nbsp;&nbsp;&nbsp;"title":"자료구조 공부하기",<br>&nbsp;&nbsp;&nbsp;"order":0,<br>&nbsp;&nbsp;&nbsp;"completed":false,<br>&nbsp;&nbsp;&nbsp;"url":"http://localhost:8080/17"<br>}|
|GET|/|전체 todo 리스트 조회|-|{<br>&nbsp;&nbsp;&nbsp;"id":1,<br>&nbsp;&nbsp;&nbsp;"title":"자바기초 공부하기",<br>&nbsp;&nbsp;&nbsp;"order":0,<br>&nbsp;&nbsp;&nbsp;"completed":false,<br>&nbsp;&nbsp;&nbsp;"url":"http://localhost:8080/1"<br>},<br>{<br>&nbsp;&nbsp;&nbsp;"id":2,<br>&nbsp;&nbsp;&nbsp;"title":"알고리즘 공부하기",<br>&nbsp;&nbsp;&nbsp;"order":0,<br>&nbsp;&nbsp;&nbsp;"completed":false,<br>&nbsp;&nbsp;&nbsp;"url":"http://localhost:8080/1"<br>}|
|GET|/{:id}|todo 항목 조회|{<br>&nbsp;&nbsp;&nbsp;"title" : "반복문 공부하기"<br>}|{<br>&nbsp;&nbsp;&nbsp;"id":1,<br>&nbsp;&nbsp;&nbsp;"title":"반복문 공부하기",<br>&nbsp;&nbsp;&nbsp;"order":0,<br>&nbsp;&nbsp;&nbsp;"completed":false,<br>&nbsp;&nbsp;&nbsp;"url":"http://localhost:8080/1"<br>}|
|DELETE|/|전체 todo 리스트 삭제|-|200|
|DELETE|/{:id}|todo 항목 삭제|-|200|  

## 구동화면
![구동화면](https://user-images.githubusercontent.com/53508659/124847770-873f4c80-dfd6-11eb-97f3-309d01de6431.PNG)

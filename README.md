# springBoard
* 해당 프로젝트는 포트폴리오목적 스프링 게시판 구현 프로젝트입니다.<br><br>
* **세부구현시스템**
   * **[게시판 CRUD](#CRUD)**
   * **[페이징 처리](#페이징)**
   * **[게시글 검색](#검색)**

---
## 개발 환경

|    Java    |  Spring boot    |        JSP            |   MySQL       |
| :--------: | :--------:      |      :--------:       | :--------:    |
|     11     |     Gradle      |   html 기반, jstl      |  JPA, Mybatis |

---

## Tools
* IntelliJ
* Git

---
## 시연영상 (Video)
- [Link](https://www.youtube.com/watch?v=JKFxuTtCB_E)<br>
---
## CRUD
<img width="654" alt="Screen Shot 2023-04-09 at 12 48 24 AM" src="https://user-images.githubusercontent.com/68188361/230730679-89f61d73-3a79-4a68-915a-04745b131e38.png"><br>
ㄴ게시글 목록 불러오기
<br>
<br>
<img width="622" alt="Screen Shot 2023-04-09 at 12 54 21 AM" src="https://user-images.githubusercontent.com/68188361/230730815-518032d8-d99e-430c-9151-926e4e9b378a.png"><br>
ㄴ게시글 불러오기
<br>
<br>
<img width="657" alt="Screen Shot 2023-04-09 at 12 48 46 AM" src="https://user-images.githubusercontent.com/68188361/230730737-92c46df0-cbd6-4f94-b7a1-bc3b39e74eab.png"><br>
ㄴ게시글 작성
<br>
<br>
<img width="632" alt="Screen Shot 2023-04-09 at 12 50 06 AM" src="https://user-images.githubusercontent.com/68188361/230730759-2b2d5066-4e36-44b0-b56f-5053057c5ac1.png"><br>
ㄴ게시글 수정
<br>
<br>
<img width="635" alt="Screen Shot 2023-04-09 at 12 54 15 AM" src="https://user-images.githubusercontent.com/68188361/230730793-10baca54-7364-4a1e-bbf7-ea9a578b41da.png"><br>
ㄴ게시글 삭제

## 페이징
<img width="66" alt="Screen Shot 2023-04-09 at 12 55 52 AM" src="https://user-images.githubusercontent.com/68188361/230730855-f2d01886-c571-4484-9c71-284ca7ce9780.png"><br>

- [x] 페이징 처리 구현 완료
- [x] 한 페이지당 몇개의 게시글 노출시킬건지 설정 가능
- [x] 한 페이지당 몇개의 페이지 이동 가능한지 설정 가능
- [x] 목록 첫페이지/마지막 페이지에 따라 '<<', '>>' 부호 숨김/노출 가능

## 검색

조건별 (제목, 내용, 작성자, 제목+내용) 검색 가능<br>
<img width="645" alt="Screen Shot 2023-04-09 at 12 49 18 AM" src="https://user-images.githubusercontent.com/68188361/230730935-92f28d0c-66da-4221-b916-37e7ac4f14a5.png"><br>
ㄴ조건별 (제목) 검색 가능
<br>
<br>
<img width="640" alt="Screen Shot 2023-04-09 at 12 49 53 AM" src="https://user-images.githubusercontent.com/68188361/230730946-04174dce-f52d-4eff-9577-87d4f6f96dd4.png"><br>
ㄴ조건별 (내용) 검색 가능
<br>
<br>
<img width="663" alt="Screen Shot 2023-04-09 at 12 49 05 AM" src="https://user-images.githubusercontent.com/68188361/230730919-bafdbd58-0c36-4497-bfcb-601db1f0cff1.png"><br>
ㄴ조건별 (작성자) 검색 가능
<br>
<br>
<img width="635" alt="Screen Shot 2023-04-09 at 12 49 31 AM" src="https://user-images.githubusercontent.com/68188361/230730955-3a2535a5-69c4-43d1-8b6a-f418cb0dd2e7.png"><br>
ㄴ조건별 (제목+내용) 검색 가능
<br>
<br>
<img width="652" alt="Screen Shot 2023-04-09 at 12 58 29 AM" src="https://user-images.githubusercontent.com/68188361/230730978-c5f04069-9db8-4aeb-93c0-db5efb893897.png"><br>
- [x] 검색 결과에 따라 페이징 처리까지 

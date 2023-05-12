# Mybatis 사용해보기


학습목표
- Mybatis 소개
- Mybatis로 database 사용해보기
- Mybatis 제어문
- Auto Generated Keys


## Mybatis 소개

Database를 사용하는 이유?
- Spring boot : Java 클래스를 통해 데이터를 다룬다. (POJO)
  1. Java 코드로 작성한 List, HashMap 등은 memory에 저장된다. 즉, 서버가 종료되면 데이터가 날아간다.
  2. 여러 서버 프로세스가 같은 기능을 하면서 Data를 공유해야 한다.
- 따라서 외부의 Database에 Data를 저장한다.

MyBatis 프레임워크
- Java 함수를 SQL 선언문과 연결지어 사용
- Java 클래스를 이용하여 SQL 결과를 받거나 SQL 선언문에서 사용할 인자를 전달한다.

```sql
select * from restaurants;
```

| 테이블이   |
| ---------- |
| 만들어진다 |

Row가 Java의 Class로 사용되어진다. (Dto, Data Transfer Object)  
테이블의 결과가 여러줄이 된다며 여러 인스턴스의 리스트 형태로 돌아온다.  

MyBais는 XML파일의 형태로 저장된다.  
그리고 Java Interface로 연결된다.  



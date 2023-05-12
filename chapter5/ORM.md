# ORM

학습목표
- 관계형 데이터베이스의 한계
- Object Relational Mapping
- JPA Hibernate


## 관계형 데이터베이스의 한계

Primary Key - Foreign Key  
다른 테이블의 튜플을 가르키기 위해 Foreign Key를 활용한다.  

객체지향인 자바에서 봤을 때 클래스 입장에서는 Foreign Key는 쓸모없는 데이터이다.  
```java
public class FoodDto{
    private int id;
    private String name;
    private int price;
    private int count;
}
```
```java
public class OrderDto{
    private int id;
    private int foodId; // food 테이블에서 값을 찾기 위한 food의 키 즉, Foreign Key
    private int orderCount;
}
```

따라서 관계형 데이터베이스에서 사용하는 자료의 형태가 객체 지향 관점에서 맞지 않아서 생기는 간극이 있다.  

```java
public class FoodDto{
    private String name;
    private int price;
    private int count;
}
```
```java
public class OrderDto{
    private Food orderFood;
    private int orderCount;
}
```

관계형 데이터베이스 : 데이터를 잘 저장하고 빠르게 조회하기 위해 탄생한 소프트웨어의 일종  

## Object Relational Mapping

ORM, Object Relational Mapping
- 앞에서 나온 간극을 줄이기 위해 탄생
- 데이터베이스를 어떤식으로 다루느냐에 관한 것
- 관계형 데이터를 객체로 표현하는 프로그래밍 기법


## JPA Hibernate


JPA, Java Persistence API
- 현재는 Jakarta Persistence
- 자바에서 가장 유명한 ORM 기법
- JPA는 이미 존재하는 자바의 객체에 데이터 상의 테이블에는 어떤식으로 표현될지를 정의를 하기 위해 탄생한 어노테이션들


예시  
```java
@Entity
@DynamicUpdate
public class FoodEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    private Long count;
}
```
- Entity, DynamicUpdate, Id, GeneratedValue가 JPA에 정의되어 있다.
- JPA 자체는 관계형 데이터를 객체로 표기하는 기능 뿐이다.

HIBERNATE
- JPA를 활용해서 데이터베이스를 다뤄주는 프레임워크
- JPA를 이용해서 ORM을 구현한 기술들 중 하나
- JPA에 대한 이해가 충분하면 직접 ORM 프레임워크를 만들 수 있다.





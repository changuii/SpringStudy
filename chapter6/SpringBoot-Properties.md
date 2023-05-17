# Spring Boot Properties


학습목표
- 설정 파일 작성
- Spring Boot Profiles
- Configuration을 통한 Bean 생성


## 설정 파일 작성

개발환경 : 자신의 컴퓨터, 도구들(JDK, SQL, IDE)  
- 자신의 컴퓨터 내부의 소프트웨어들을 사용하게 된다.

실제로는  
1. 서버 컴퓨터
2. 도커를 이용한 컨테이너
3. AWS등과 같은 클라우드 (요즘에 많이 사용)
- 실제 서비스를 실행하는데는 여러가지 다양한 환경을 구성할 수 있다.  

(서버 컴퓨터 + 컨테이너, 서버 컴퓨터 + 컨테이너 + AWS 등..)  

yaml 설정파일  
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/demo_jpa_schema
    username: demo_jpa
    password: _ckddml7410
  jpa:
    hibernate:
      ddl-auto: create
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect

```
변경되어야 하는 부분  
- url, username, password (데이터 베이스에 관한 내용, 데이터 베이스에 따라 달라진다.)  
- hibernate, ddl-auto, show-sql 등 상황에 맞게 바꿔야 한다.

따라서 상황에 맞는 설정을 사용하도록 구성해보자  

## Spring Boot Profiles

YAML 또는 properties 파일
- spring.profiles.active로 사용할 파일 결정
- 2.4.0 이전 : spring.profiles.include 사용
- 2.4.0 이후 : spring.config.activate.on-profile 사용

```yaml
spring:
  profiles:
    active: local
---
spring: // 현재 profile이 loca일 때 실행
  config:
    activate:
      on-profile: local
```

---를 통해 설정들을 구분하고 active에 설정을 고를 수 있다.  

## Configuration

```java
@Configuration
public class DemoConfig{

  @bean
  public Gson gson(){

  }
} 


```

@Configuration을 통해서 외부 라이브러리를 IOC컨테이너의 빈으로 관리하기 위해 사용할 수 있다.  
@Bean을 통해 제공  


앞에 까지는 SpringBoot에서 사용하는 설정이다.  
우리가 따로 애플리케이션을 진행하기위한 설정들을 넣는 방법  

```yml
custom:
  property:
    single: custom-property
    comlist: comma,sparated,list,to,value
    ncp:
      id: api-id
      key: api-key
      url: https://ncp.com
# == .properties
# custom.property.single
# custom.property.comlist

```

Spring boot와는 상관이없지만 설정값으로 넣어주어야 하는 부분들  

```java
@Configuration
public class DemoConfig{

  @bean
  public Gson gson(){
  }

  @Value("${custom.property.single}")
  private String customProperty;

  @Value("${custom.property.comlist}")
  private List<String> customCommaList;

} 
```

설정에서 작성된 값들이 Value로 들어가게된다.  


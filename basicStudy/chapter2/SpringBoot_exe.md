# Sprig Boot 실행하기

학습 목표
- 일반적인 웹 서비스의 배포 구조
- Java와 Jar
- Web Application의 구조


## 일반적인 웹 서비스의 배포 구조
---

사용자 브라우저에 주소창에 주소를 넣으면 서버로 요청이 가고 해당 서버에서 웹 페이지를 응답하여 준다.  

요청은 컴퓨터 내부의 몇몇 프로세스로 들어오게된다.  
예시) APACHE, NGINX (웹 서버 프로그램)

- IP는 컴퓨터 호스트를 특정하고 PORT는 컴퓨터 내부의 프로세스를 특정한다.  
  
전통적인 구조는 서버 프로세스의 파일 시스템에서 파일을 응답을 보냈다.  
또는 다른 웹 애플리케이션 서버로 요청을 돌려버린다.  
(웹 서버는 HTTP의 요청에 응답하거나 요청을 다른 곳으로 웹 애플리케이션 서버는 서비스를 제대로 제공하기위한 기능들을 제공하는 서버 두 가지는 조금 다르다.)  

웹 애플리케이션 서버  
- Java Web Application (WAR 파일) or Spring Boot을 사용하여 서비스를 제공  
  
서버의 흐름  
Hardware -> NGINX -> Filesystem (정적)  
Hardware -> NGINX -> Web Application Server ->SpringBoot (동적)  
Hardware -> Spring boot (바로 넣을 수 있다.)  
서버의 구성은 다양한 방법이 가능하다.  
요즘에는 Docker를 앞에 두고 사용하기도 한다.  

## Java와 Jar
---
Spring Boot 프로젝트를 빌드하면 jar 파일이 나온다.  

JAR : Java ARchive
- Java로 작성 후 컴파일된 Java Bytecode
- 실행을 위해 필요한 다양한 자원을 배포를 위하여 모아놓은 파일의 형태
- 쉽게 말해 다른 형태의 압축파일이다.
- 따라서 압축을 해제할 수도 있다.
  - jar파일들이 project의 디렉토리와 매우 비슷하다.
  - jar파일은 .clss이고 우리의 소스 코드는 .java 파일이다.  

jar 파일은 'java -jar' 명령으로 실행할 수 있다.


## Web Application의 구조
---

| Presentation Layer | 사용자와 직접적으로 맞닿는 부분    |
| ------------------ | ---------------------------------- |
| Logic Layer        | 요청을 처리하는 결정을 내리는 부분 |
| Data Layer         | 데이터를 저장하고 불러오는 부분 |


Spring Boot의 작은 구조  
| Dispatcher Servlet | Controller    | Service    |     |
| ------------------ | ------------- | ---------- | --- |
| Dispatcher Servlet | View Resolver | Repository | Database |

(개발자가 만든다.)
- Dispatcher Servlet : request를 받고 컨트롤러에게 전달
- Controller : Dispatcher Servlet에 요청을 직접적으로 받는 클래스형태
- Service : 컨트롤러가 검증해낸 요청을 받아서 사용자의 입력에 따른 데이터의 조작을 결정한다. 클래스형태
- Repository : 데이터 레이어로써 데이터의 표현을 받아서 실제 데이터를 저장하고 데이터 표현을 불러와서 데이터를 불러오는 역할
- View Resolver : 데이터, 결과를 어떤식으로 할지를 결정하는 부분
- Database : 외부의 데이터베이스에 저장 및 로드
  


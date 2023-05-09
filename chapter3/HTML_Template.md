# HTML Template

학습목표
- 동적 HTML
- JSP와 Thymeleaf
- React, Vue, Node와 Spring Boot


## 동적 HTML

www.example.com  
- 예시로 자주 사용되는 HTML페이지
- 사용자, 상황에 따른 내용 변화가 없다.

www.naver.com  
- 네이버
- 현재 시각, 사용자에 따른 내용이 달라진다.

Static Contents  
- 정적
- 이미 작성이 완료되어 변하지 않는 파일들, HTML, CSS, JS, Image 등

Dynamic Web Page
- 동적
- 서버에서 HTML 문서의 내용을 데이터에 따라 다르게 작성하여 제공되는 페이지

## JSP와 Thymeleaf

JSP  
- HTML과 유사

```gradle
dependencies{
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'  // Thymeleaf
        implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'  // JSP
        implementation 'javax.servlet:jstl'  // JSP
}
```


## React, Vue, Node와 Spring Boot

Framework 선택의 기준  

React (JavaScript library)  
- Building user interface
- UI를 만들기 위한 라이브러리 / 프레임워크 
- HTML을 효율적으로 작성하기 위한 기술

Vue.js
- Building user interface
- UI를 만들기 위한 라이브러리 / 프레임워크 
- HTML을 효율적으로 작성하기 위한 기술

Node.js
- JavaScript를 컴퓨터 시스템에서 실행
- back-end JavaScript runtime environment
- Javascript를 브라우저 외부에서 사용하기 위한 기술
- 일반적으로 웹 어플리케이션을 만드는데 활용

Front-End  
- React, Vue.js, JSP, Thymeleaf

Back-End
- Node.js, Spring-Boot


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




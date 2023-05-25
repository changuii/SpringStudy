# Spring Boot Tests


학습목표
- Testing에 대하여
- Spring Boot 테스트 작성
- Test Driven Development


## Testing에 대하여

여태까지 개발했던 스프링 부트는 Postman을 사용하여 HTTP요청/응답을 통해 기능을 사용해보았습니다.  
산출물의 기능적 측면의 테스트  
- 자동차를 시운전해본다. 

개발자로서 프로그램을 만들 때 
Spring에서는 Controller Service Repository 등의 클래스들이 서로 상호작용을 한다.
- Controller는 DTO를 Service로 보내고 Service는 Entity, DAO를 Repository로 보낸다.  

이러한 우리가 작성한 자바 소스코드들의 개별 코드 단위의 테스트가 가능하다.  
1. 클래스 함수들이 제대로 작동하는가
2. 여러 클래스들이 서로 상호작용하는 것이 잘 작동하는가
3. 기능들이 잘 작동하는가(Postman 사용)

자동으로 추가되는 종속성  
```gradle
testImplementation 'org.springframework.boot:spring-boot-starter-test'
```
아래의 7가지 라이브러리들을 포함하는 라이브러리이다.  
모두 통합해서 많이 사용한다.  
- JUnit: 사실상의(de-facto) java 어플리케이션 Testing 표준 라이브러리
  - @RunWith, @Before, @Test
- Spring Test: Spring 어플리케이션 Test 지원 라이브러리
  - @WebMvcTest, SpringRunner.class
- AssertJ: 가독성 높은 Test 작성을 위한 라이브러리
- Hamcrest: Test 진행시 제약사항 설정을 위한 라이브러리
  - jsonPath()
- Mockito: Test용 Mock 라이브러리
  - Mock
- JSONassert: JSON용 Assertion 라이브러리
- JsonPath: JSON 데이터 확인용 라이브러리

테스트 개발자가 따로있을 정도로 매우 큰 분야이다.  

프로그래밍 언어로 무슨일을 할 수 있는지 확실히 알고 난 후 확실하게 공부할 것.  

## Test Driven Development, TDD

Test Driven Development, TDD
- 테스트 주도 개발
- 실제 작동하는 코드 이전에 통과해야할 테스트를 우선 만드는 개발 방식


아래 행동을 반복
1. 존재하지 않는 코드에 대한 테스트 작성, (당연히 테스트는 실패 Red)
   - 목적지를 미리 만든다. 길이 뚫려있지 않는다.
2. 테스트를 통과하는 코드를 작성 (Green)
   - 목적지로 길을 만든다.
3. 작성된 코드를 수정 (Refactor)

- 테스트를 작성
- 테스트 실행 및 실패
- 테스트를 통과하는 코드 작성
- 테스트 통과 확인
- 코드 정리 (리팩토링)





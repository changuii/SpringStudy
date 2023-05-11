# Spring Stereotypes


학습목표
- Component란?
- Service, Repository 사용하기

## Component란?

@Component

Spring boot의 main위의 어노테이션을 타고 들어가면 다양한 어노테이션들을 볼 수 있다.  

@ComponentScan을 이용해 사용할 Bean의 범위를 정해줄 수 있다.  
함수단위 : @Bean, 클래스 단위 : Component  

Component
- 모든 Bean에 Component를 사용해도 작동하기는 한다.
- Controller
  - RequestMapping과 함께 사용 MVC의 'Controller' 역할을 함을 알림
- Repository
  - Data Access Object와 같이 실제 데이터 근원과 소통하는 부분임을 알림
- Service
  - 비즈니스 로직이 구현된 부분임을 알림

구현상으로 엄청난 차이가 있지는 않지만 개념적인 분류를 위해서 사용한다.  



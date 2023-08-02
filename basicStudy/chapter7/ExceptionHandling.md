# Exception Handling




학습목표
- Java의 예외처리
- Spring Boot의 예외처리 방법들


## java의 예외처리 

Exception, 예외
- 특수한 처리를 필요로 하는 비상적 또는 예외적 상황

```java
// a 또는 b가 null일 경우 NullPointerException이 발생
public void compareLength(String a, String b){
    int aLength = a.length();
    int bLenght = b.length();
}
// 이하생략
```

기대하지 않았던 동작이 일어났을 때 그것에 대한 처리를 필요로 한다.  

```java
try{
    // 예외가 일어날 수 있는 구역
} catch(NullPointerException e){
    // 예외가 발생할 시 실행
} final{
    // 예외의 발생 여부와 관계없이 항상 실행하는 코드
    // 예외의 발생과 무관 
}
```

예외상황을 catch하여 프로그램이 중단되지않고 그냥 지나가도록 한다.  
try, catch, finally  

```java
public void compareLength(String a, String b) 
throws NullPointerException{
// 생략
}
```

throws를 통해 함수를 호출하는 대상이 함수의 모습을 보고 이 예외를 발생시킬 가능성이 존재하구나라고 생각하고 처리한다.  
예외 처리를 호출하는 대상에게 전가한다.  
Java에서는 Method Signature의 일부로, 처리되지 않은 예외는 Compile Error를 발생시킨다.  
*RuntimeException 제외  

## SpringBoot의 예외처리 방법들


살펴볼 예외처리들  
1. RespnseStatusException : 단발적 예외
   - 이것을 통해서 특출나게 강한 예외처리 메서드를 만들 필요가 없을 때
2. @ExceptionHandler : Controller 내부 예외  
   - Controller 내부에서 함수에 붙여서 선언을 함으로써 특정한 예외에 대하여 처리를 할 수 있는 ExceptionHandler
3. HandlerExceptionResolver : 예외 처리 Handler
   - 실제로 예외를 처리를 하는 것을 구성함으로써 애플리케이션 전체의 예외처리를 적용하는 것 
4. @ControllerAdvice : ExceptionHandler 모음 (Bean의 일종)


ResponseStatusException
- POC같이 빠르게 간단한 작업을 만들어야 하는 경우
- 또는 빠르게 기능을 먼저 구현하고 오류 지점을 파악하는데 사용
- 어느 시점에서 일어나는지 모아두면 나중에 제대로 예외처리 규칙을 만드는데 유용하다.
- 따라서 그 전까지 사용한다.
- 초기단계에서 많이 사용한다. 자세히 작성하기 어렵다.  

@ExceptionHandler  
- Controller 혹은 RestController 클래스 내부에서 선언을 할 수 있다.
- 함수에 붙여준다면 이 함수는 지정된 예외에 대해서 그 예외를 처리해줄때 동작하는 함수가 된다.
- 컨트롤러 내부에서 예외가 발생했을 때 그 예외가 정의되어 있다면 그 함수로 가서 작동한다.


HandlerExceptionResolver  

@ControllerAdvice  

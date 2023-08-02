# Controller와 RestController

학습목표
- Spring MVC
- Controller와 RequestMapping
- Controller와 RestController

## Spring MVC

Model - View - Controller (패턴)  
- 코드를 어떤식으로 나누어서 사용하는지
- 역할에 따른 분류 (패턴)

View  
- 사용자가 확인하는 데이터의 표현
Controller  
- 사용자의 입출력을 다루는 부분
Model
- 서비스 데이터 자체

사용자가 View에서 모습을 본다.  
사용자가 Controller를 사용하여 (사용) 전달  
Controller는 Model을 조정  
Model은 Controller에서 지시받은 조정을 통해 View를 갱신한다.  
- 즉, 코드들을 어떠한 형태로 구성할 것인지를 생각한 것

![image](../image/SpringMVC.png)

Front Controller Pattern  
- Dispatcher Servlet이 (MVC를)직접적으로 관리하고 사용자와 대화하는 것  
External Client  
- 브라우저 또는 다른 클라이언트 프로그램
Dispatcher Servlet  
- Spring Boot의 일부분
Handler Mapping  
- 패스와 실제 메소드와 실제 연결이 어떻게 되어있는지 구성, 관리
Controller  
Model  
- 실제 데이터
View Resolver  
- View 역할

동작  
1. 외부의 요청 발생
2. 요청 경로 확인을 위해 전달
3. Controller로 전달
4. Model 조작
5. 갱신된 데이터 전달
6. 응답 전달
7. 응답을 Client로 전송
   1. 데이터 전송 또는
   2. 데이터를 포함한 View 제작
8. 사용자에게 View 제공

앞의 대부분은 자동으로 되고 우리가 코드를 구성하는 부분은 Controller와 Model부분을 작성한다.


## Controller와 RequestMapping 실습

어노테이션  

@Controller  
- Class를 Controller로 선언
```java
@Controller
```

@RequestParam()  
- id를 URL로 파라미터로 가져온다.
- Query로 id값을 가져온다. ?name="value"
```java
@RequestParam(name = "id", required = false, defaultValue = "")
```

@RequestMapping
- request가 들어왔을 때 매핑해주는 값
```java
 @RequestMapping(
            value = "hello",    // 요청 URL의 PATH loaclhost:8080/hello
            method = RequestMethod.GET // HTTP GET메소드, URL주소로 문서를 가져오는 방식은 GET
    )
```

@GetMapping()
- 메소드를 GET으로 고정한다.
```java
@GetMapping(    // 메소드가 GET으로 고정되어있다.
            value = "hello/{id}"   
    )
```

@PathVariable
- URL 경로를 통해 변수를 가져온다.
```java
@PathVariable("id")
```

@ResponseBody
- Controller를 통해 응답하는 값을 Body로 지정한다.
- Controller는 기본적으로 html을 반환하기 위해 경로를 지정해준다.
- 따라서 어떤 데이터를 반환하고자 할 때(ex: 객체, 이미지 등..) 함수앞에 작성해주어야 한다.
- Spring에서는 객체를 응답할 때 일반적으로 통용되는 데이터인 JSON, XML 형태로 전달해줄 수 있다.
```java
public @ResponseBody SamplePayload getProfile()
```

@RestController
- 해당 클래스를 RestController로 지정한다.
- RestController는 기본적으로 데이터를 응답하기위해 사용하기 때문에 ResponsBody를 사용할 필요가 없다.
```java
@RestController
```

@RequestMapping 클래스
- RequestMapping은 클래스에도 지정할 수 있다.
- 클래스에 지정된다면 해당 클래스 내의 모든 함수들은 해당 디렉터리의 하위 디렉터리로 지정된다.
- 밑의 예시의 경우에 localhost:8080/rest/해당 클래스의 메소드 디렉터리
```java
@RequestMapping("/rest")  // class에도 RequestMapping(디렉터리)를 작성가능.
public class SampleRestController
```

이미지 또는 비디오 응답  
- Spring에서 이미지 또는 비디오는 바이트로 구성되기 때문에 byte[]형태로 반환해준다.
- MediaType을 지정해주어야 한다.
```java
@GetMapping(
            value = "/sample-image",
            produces = MediaType.IMAGE_PNG_VALUE  // MediaType 선택
    )
    public byte[] sampleImage() throws IOException{  // 이미지와 비디오는 기본적으로 다 byte로 구성되기 때문에 byte형태로 제공한다.
        InputStream inputStream = getClass().getResourceAsStream("/static/spring-boot.png");  // 들어오는 문자열을 resources 폴더 안에서 찾아간다.

        return inputStream.readAllBytes();
    }
```


## Controller와 RequestMapping

요청 경로를 설정하기 위해 Controller Annotation을 사용하자.  
RequestMpping을 이용해 경로에 따라 실행될 함수를 지정할 수 있다.  
Method 별로 별도의 Annotation이 존재한다.  
- GetMapping, PostMapping 등..  

HTML외에 데이터 전송을 위해 Body와 MediaType을 설정할 수 있다.
- View Resolver를 거치지 않고 바로 데이터를 클라이언트에게 돌려준다. (6번 경로)  

RestController  
- 간단하게, Controller + ResponseBody  

기본적으로 어떠한 형태의 응답이든 데이터의 일종이다.  

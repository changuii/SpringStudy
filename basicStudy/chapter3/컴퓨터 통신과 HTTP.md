# 컴퓨터 통신과 HTTP

학습목표
- HTTP란?
- HTTP 요청과 응답의 형식
- Media Types

## HTTP란?

| OSI 모델         |
| ---------------- |
| 응용 계층        |
| 세션 계층        |
| 전송 계층        |
| 네트워크 계층    |
| 데이터 링크 계층 |
| 물리 계층        |

| TCP/IP 모델 |
| ----------- |
| 응용 계층   |
| 전송 계층   |
| 인터넷 계층 |
| 네트워크 접근 계층 |

응용 계층 : HTTP, SMTP, FTP  
- 주고받을 데이터를 어떤 규칙을 가지고 작성하느냐  
- Spring Boot가 도움을 준다.

HTTP : HyperText Transfer Protocol  
- HyperText : 정보를 담고있는 문자 (파란색 링크, HyperLink)
- Trsnsfer : 통신
- Protocol : 규약
- 응용 계층에 정의된 통신 규약
- 서버와 클라이언트 간에 메시지를 전달하는 형식을 정의한 규약

REST : REpresentational State Transfer  
- 상태에 대한 표현을 전송하자는 이론
- 좋은 API를 만들기 위한 규칙들이 정의되어있다.
- HTTP와 동일하지 않다.
- Backend 서버를 만들때 남용되는 말
  
## HTTP 요청 및 응답의 형식

요청 메시지 형식  

| 요청라인 | 메소드 | 경로 | 버전 |
| -------- | ------ | ---- | ---- |
| 헤더라인 | ..     | ..   | ..   |
| 공백라인 | ..     | ..   | .. |
| 개체몸체 |        |      |      |

Request Line: Method, Path, Version  
Request Headers: HTTP 요청에 대한 부수적인 데이터  
Request Body: HTTP 요청에 관한 실제 데이터

응답 메시지 형식  

| 상태라인 | 버전      | 상태코드 | 문장 |
| -------- | --------- | -------- | ---- |
| 헤더라인 | ..        | ..       | ..   |
| 공백라인 | ..        | ..       | ..   |
| 개체몸체 | HTML 문서 |          |      |

Status Line: 요청 처리에 대한 상태 표시줄  
Response Headers: HTTP 응답에 대한 부수적인 데이터  
Response Body: 응답 데이터

URL  
![ex_screenshot](/image/URL.png)
- Uniform Resource Locator: Internet 상에 자원의 위치를 나타내는 문자열
- Path 앞은 인터넷 상의 컴퓨터를 나타내는 부분
- Path 뒤는 컴퓨터 안의 위치(경로) 부분
- 컴퓨터 안의 위치를 신경써서 코드를 작성해야 한다. (fragment는 제외)
- fragment : 하나의 파일에 어떤 부분을 나타내는 것
- userinfo : 이메일에 포함되는 자신의 로그인 정보 같은 것


## Media Types

Media Type
- 인터넷 상에서 주고받는 데이터의 형식
- image/jpeg, video/mp4, application/javascript
- HTTP의 content-type 헤더, media type을 알려주는 헤더라인

Content-Type : text/html
- HTTP의 응답 데이터(Body)의 Media Type을 알려주는 헤더

Backend가 알고 다루게될 Media Type
- application/json
- multipart/form-data
- JSON과 Multipart Form-Data를 많이 활용한다.

JSON - JavaScript Object Notation
- 데이터를 주고받을 때 흔히 사용하는 형태
- 속성(Attribute) - 값(Value)의 형태와 배열을 활용한다.

![ex_screenshot](/image/JSON.png)

```java
public class SamplePOJO{
    private String name;
    private int age;
    private String occupation;
    private List<String> projects;
}
```
JSON  
```json
{
    "name": "박지호",
    "age": 35,
    "Occupation": "Developer",
    "projects":[
        "Startup School",
        "The Origin"
    ]
}
```
- 일반적인 데이터를 표현한 객체(VO)는 JSON 형태로 주고 받는다.
- Boolean도 가능
- 중괄호 안에 ket-Value 형태로 들어간다.



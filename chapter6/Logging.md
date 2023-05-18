# Logging

정보를 얻기 위해서 하는 것  


학습목표
- Logging의 기본 개념들
- Logback 설정법


## Logging의 기본 개념들

```java
@RequestMapping("/")
public String index(){
    logger.trace("a trace message");
    logger.debug("a debug message");
    logger.info("a info message");
    logger.warn("a warn message");
    logger.error("a error message");
    return "index"
}
```

Log Level  
- 남길 메시지의 중요도
- 위의 다섯가지 로그의 함수들이 로그레벨이라고 한다.
- 어떤 프레임워크인가 어떤 언어인가에따라 조금씩 달라진다.  

보통 System.out.println을 통해 어떤 시점에 어떤 변수가 어떤 값들을 가지고 있는가 또한 어느시점까지 프로그램이 실행되는가 등을 확인하기 위해서 사용해왔다.  

하지만 상용서비스에서는 프로그램이 돌아가고 있는 것을 24시간 지켜보는 것이 아니기 때문에 어느 시점에 무슨일이 일어나는지 확인하는 방법이 로그를 남기는 방법이다.  
로그랑 사용이력을 남기는 것은 다르다고 보아야한다.    

로그(무슨 일이 일어났는지, 요청이 들어왔다. 어떤 값이 들어왔다. DELETE, POST함수에 전달한다. 등등.. 개발적인 측면에서)  

사용이력(서비스를 어떻게 사용했는가, 데이터베이스에 이력을 남기고 통계를 낸다. )

호환성을 좋게 만들기 위하여 영어로 사용하는 것이 좋다.  
의미없는 메시지보다는 어떤 일이 있었는지를 남겨야 한다.  

```java
@RequestMapping("test-log")
public  void testLog(){
    logger.trace("a trace message");
    logger.debug("a debug message");
    logger.info("a info message");
    logger.warn("a warn message");
    logger.error("a error message");
    }
```
실행결과  
```shell
2023-05-18 23:34:15.865  INFO 17720 --- [nio-8080-exec-3] d.c.misson2.controller.MediaController   : a info message
2023-05-18 23:34:15.865  WARN 17720 --- [nio-8080-exec-3] d.c.misson2.controller.MediaController   : a warn message
2023-05-18 23:34:15.865 ERROR 17720 --- [nio-8080-exec-3] d.c.misson2.controller.MediaController   : a error message
```

trace와 debug는 발생하지 않았다.  
이것이 바로 로그 레벨이다. 
- 로거를 통해서 작성하고자하는 메시지의 중요도, 위험도에 대한 설명이다.
- 5가지의 순서대로 trace일수록 사소한 메시지이고 error로 갈수록 더 위험한 수준의 메시지가 된다.

TRACE : 변수에 값을 할당했다. 그 값을 어디에 넣었다. 즉 하나하나 사소한 일처리에 대한 로그 (잘 사용하지 않는다.) 개발단계에서 사용하고 상용단계에서는 올리지않는다.  
DEBUG : 어떠한 행위가 이루어졌다.  
INFO : 일반적인 진행상황에 대한 메시지  
WARN : 문제가 생길수도 있다는 메시지(문제가 발생하지는 않았지만 미래에는 문제가 발생할 수도 있다.)  
ERROR : 메시지가 발생함으로써 서비스가 정상적으로 진행되지 않았다.  


TRACE와 DEBUG는 출력되지 않았다. 
- Spring Boot에서는 기본적으로 INFO레벨의 로그 이상의 위험도를 가지는 메시지를 출력한다.  

```yml
logging:
  level:
    root: debug
```
해당 설정을 통하여 debug이상의 위험도를 가지는 메시지를 출력한다.  

```shell
2023-05-18 23:41:51.806 DEBUG 7940 --- [nio-8080-exec-1] d.c.misson2.controller.MediaController   : a debug message
2023-05-18 23:41:51.806  INFO 7940 --- [nio-8080-exec-1] d.c.misson2.controller.MediaController   : a info message
2023-05-18 23:41:51.806  WARN 7940 --- [nio-8080-exec-1] d.c.misson2.controller.MediaController   : a warn message
2023-05-18 23:41:51.806 ERROR 7940 --- [nio-8080-exec-1] d.c.misson2.controller.MediaController   : a error message
```

debug까지 로그내용이 나와 매우 혼잡하게 출력되어 찾기가 힘들었다!  
반대로 warn까지 한다면 로그가 매우 적어질 것이다.  

```yml
logging:
  level:
    root: warn
    dev.changui: info
```
```java
private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
```
```shell
dev.changui.misson2.Misson2Application
```

Logger의 이름: dev.changui.misson2.Misson2Application  
패키지의 범위를 설정함으로써 해당 패키지의 로그가 어떤 레벨까지 출력될지를 선택할 수 있다.  
따라서 해당 패기지에서는 INFO메시지까지 출력된다.  

여기서는 해당 패키지의 이름이 d.c로 요약되었다.  
```shell
2023-05-18 23:49:47.435  INFO 9344 --- [nio-8080-exec-1] d.c.misson2.controller.MediaController   : a info message
2023-05-18 23:49:47.436  WARN 9344 --- [nio-8080-exec-1] d.c.misson2.controller.MediaController   : a warn message
2023-05-18 23:49:47.436 ERROR 9344 --- [nio-8080-exec-1] d.c.misson2.controller.MediaController   : a error message
```

이러한 설정들은 JVM 실행시 인자로 전달이 가능하다.  
```shell
java -Dlogging.level.org.hibernate=info -jar spring-boot.jar
```

## LogBack 설정법

지금까지의 로그들은 실행중에만 작성이되고있다.  
하지만 서비스를 지켜보고있지 않더라도 나중에 볼 수 있어야 한다. 즉, 로그를 남겨두어야 한다.  

이때까지 사용한 Logger는 LogBack에서 제공하는 인터페이스를 제공받아서 사용한 것이다.  

Logger는 인터페이스이고 Logger를 구현한 여러가지 프레임워크 중에 하나를 사용하게 된다.  

기본적으로 Spring boot에서 사용하는 로거는 LogBack 라이브러리이다.  

Logback
- SpringBoot에서 기본으로 사용하는 Logging Framework

![Logback-classDiagram](../image/LogBackClassDiagram.jpg)

Appender라는 Interface를 통해 logger의 동작을 정의한다.  
- 출력 위치, 파일 위치
- 파일 생성 주기 등
- 어떤 형식으로 로그를 출력하고 어디에다가 저장할지 등을 설정할 수 있는 인터페이스의 일부분이다.  

XML을 통해 log level 및 appender 등을 정의할 수 있다.  

ConsoleAppender
- 콘솔에다 출력을 하는 어펜더  
- 콘솔 : 터미널 등..

FileAppender  
- 파일로 출력을하는 어펜더  

굉장히 복잡하다.  
따라서 콘솔 어펜더가 무엇이고 어떻게 선언을 하는지  
그리고 파일 어펜더 중에서 어느 정도 일정한 기간에 이력을 남기게 되는 RollingFileAppender를 보도록 한다.  


[공식 원문](https://logback.qos.ch/manual/configuration.html)

resources에 logback-spring.xml파일을 생성한다.  

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <property name="LOGS" value="./logs" /> <!-- xml에서 사용하기 위한 특정 값을 선언하는 것-->

    <!-- Appender 선언문 
    name : 변수명
    class : Logback에서 제공하고 있는 어펜더 구현체중에 하나
    layout : 어떠한 특정 패턴을 줌으로써 메시지가 어떻게 작성될 것인지를 정의한 구문 --> 
    <appender name="Console" 
              class="ch.qos.logback.core.ConsoleAppender">
        <layout class="ch.qos.logback.classic.PatternLayout">
            <Pattern>
                %black(%d{ISO8601}) %highlight(%-5level) [%blue(%t)] %yellow(%C{1.}): %msg%n%throwable
            </Pattern>
        </layout>
    </appender>
    <!-- RollingFile Appender 선언문
    file : 파일에 대한 정의, ${LOGS}는 위에 정의해둔 값을 가져온다.
    -->
    <appender name="RollingFile"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOGS}/spring-boot-logger.log</file>
        <encoder
                class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <Pattern>%d %p %C{1.} [%t] %m%n</Pattern>
        </encoder>
        <!-- RollingFile Appender의 핵심
        rollingPolicy : 일정한 규칙을 가지고 파일을 생성을 해서 이전에 작성되었던 로그를 해당하는 파일로 옮겨받고 실제 돌아가는 로그 파일을 비워주는 것
        filenamepattern : 파일명의 규칙
        MaxFileSize : 한 파일이 최대로 도달할 수 있는 용량
        MaxHistory : 최대 생성될 수 있는 로그파일의 갯수
        totalSizeCap : 결과적으로 모든 로그 파일들의 용량의 최대치 -->
        <rollingPolicy
                class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${LOGS}/archived/spring-boot-logger-%d{yyyy-MM-dd-HH-mm}.%i.log
            </fileNamePattern>
            <timeBasedFileNamingAndTriggeringPolicy
                    class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <maxFileSize>10MB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
    </appender>
    <!-- 로그레벨을 설정할 수 있다.
    root : 기본적으로 모든 패키지들이 적용되어야될 레벨
    appender-ref : 어떤 appender를 사용을 할지를 정의, 만약 RollingFile을 지운다면 기본적인 로그들은 RollingFile Appender를 사용하지 않는다.
     -->
    <root level="info">
       <appender-ref ref="RollingFile" />
        <appender-ref ref="Console" />
    </root>
    <!-- 
        logger의 이름을 패키지명으로 제공함으로써 패키지명으로 로그레벨을 지정할 수 있다. 
        additivity : root에는 존재불가, root와 별개로 작동할 것인가
        true라면 root와 중복 출력되어 총 2번 출력된다.
        false로 두는 것을 추천
        appender-ref : 어떤 appender를 사용을 할지를 정의, 여기에 정의된 dev.aquashdw 패키지의 로그들은 RollingFile과 Console Appender를 사용하게 된다.  
     -->
    <logger name="dev.aquashdw" level="trace" additivity="false">
        <appender-ref ref="RollingFile" />
        <appender-ref ref="Console" />
    </logger>

</configuration>
```

해당 내용을 포함시켜 실행시키면 로그에 대한 디자인 등이 바뀐 것을 볼 수 있다.  

```yml
logging
  config: classpath:logback-spring-test.xml
```  
해당 설정을 통하여 logback에 대한 xml파일을 설정하여 줄 수 있다.  
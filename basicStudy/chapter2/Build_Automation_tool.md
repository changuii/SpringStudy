# Build Automation Tool

학습 목표
- Java와 Build Automation Tool
- Maven 알아보기
- Gradle 알아보기

## Java와 Build Automation Tool
---
java
- JVM - JRE - JDK
- 자바는 자바 가상 머신으로 기계어로 만든다.
- Java로 이뤄진 프로젝트는 .java 파일에 정의된 Java Source 코드로 구성된다.
  
OpenJDK
- javac : Java Compiler, 자바를 자바 기계어로 바꾸는 명령어  
- javac를 통해 자바 바이트코드로 만든다.
- javac를 통해 스프링부트를 실행시키면 import오류가 발생한다.
- javac를 통하여 스프링부트의 모든 라이브러리들을 컴파일 해주어야한다.
- 따라서 javac 명령어만 가지고 전체 프로젝트를 다루는건 매우 복잡한 일이다.
- 스프링 부트에서는 Java Bytecode를 변환하고 테스트(생략 가능) 이후 실행 가능한 파일로 제작한다. (패키징), javac로 하기에는 매우 복잡

그래서 등장한 것이 Maven과 Gradle  
Build Automation Tool : Maven과 Gradle  

## Maven
---

Spring initializr에서의 Maven Project  
Maven
- Java를 위한 Build Automation Tool
  - C#, Ruby 등의 다른 언어를 위해서도 사용 가능(하지만 일반적으로 자바에서 많이 사용)
- Project Object Model (POM)
  - xml의 형태로 프로젝트를 정의
  - pom.xml을 분석해 프로젝트를 빌드
- Spring의 내용은 모두 같지만 pom.xml만 다르다.  
  
pom.xml의 형식
- parent /parent
  - 현재 프로젝트가 어떤 프로젝트의 하위 프로젝트인가
  - 모든 SpringBoot는 Spring-boot-starter-parent를 부모로 가진다.
- SpringInitialzr에서 작성한 name, GroupId, artifactId 등을 가진다.
- version, 1.2.3-SNAPSHOT
  - 1, 메이져 버전으로 상하위 호환이 안되며 대규모 패치이다.
  - 2, 마이너 버전으로 상하위 호환이 되며 새로운 기능의 추가
  - 3, 패치 버전으로 기능적인 부분이 없고 버그, 사소한 변경사항을 발표
  - SNAPSHOT : 개발단계에서 매우 빠르게 변경사항이 일어난다.
- dependencies
  - 외부 프레임워크, 라이브러리에 대한 내용이 들어가는 곳
  - dependency코드로 묶여진 것들이 모여있다.
- build
  - plugins : plugin들이 모여있다, Sringboot가 자동으로 추가되어 있다.

Maven Repository : mvnrepository

## Gradle
---
- Java를 위한 Build Automation Tool
  - C, C++, Javascript 등을 위해서도 사용할 수 있다. (잘 사용하지는 않는다.)
- build.gradle
  - groovy라는 언어로 프로젝트 정의
  - Sub-project 등을 포함시키는 용도의 settings.gradle도 있다.
  - Kotlin을 사용하여 정의할 수도 있다. (build.gradle.kts)
  
- 대부분이 같지만 build.gradle과 settings.gradle이 있다.
- 자기만의 Gradle 빌드 과정을 만들 수 있다.  

Gradle Repository : mvnrepository, Maven과 같은 곳이다.
package dev.changui.jpa.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 어디에 붙을 수 있는가
@Retention(RetentionPolicy.RUNTIME)  // 이 어노테이션이 실제로 어느시점까지 컴퓨터상에 존재할 것인가, Source-소스코드로만 존재 Class-컴파일 까지 Runtime-실행 까지
public @interface LogExecutionTime {

}

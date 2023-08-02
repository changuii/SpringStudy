package dev.fristchang.demo;

import org.springframework.stereotype.Component;

@Component
public class testImplementation implements  TestInterface{

    @Override
    public void sayHello() {
        System.out.println("hello !!!!!!");
    }
}

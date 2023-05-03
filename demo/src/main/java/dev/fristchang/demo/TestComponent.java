package dev.fristchang.demo;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    private TestInterface testInterface;
    public TestComponent(TestInterface testinterface, int gradeBean){
        this.testInterface = testinterface;
        System.out.println("gradeBean : "+gradeBean);
    }

    public void sayHello(){
        this.testInterface.sayHello();
    }

}

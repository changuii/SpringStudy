# Spring IoC

학습목표
- Java의 Interface
- Spring IoC Container와 DI
- Spring과 Spring Boot의 차이

## Java의 Interface
---

자동차 -> 운전자, 

```java

두 가지의 자동차가 있을 때 AnotherCar는 Road를 달릴 수 없다.
가용성을 가지기 위해 인터페이스 사용
public class Road{
    private ArrayList<SimpleCar> carList;
}

public class SimpleCar{
    private CarDriver driver;
    private int velocity;

    public SimpleCar(CarDriver driver, int velocity){
        this.driver = driver;
        this.velocity = velocity
    }
    // set get
    public void accelerate(){
        this.velocity += 10;
    }

    public void break(){
        this.velocity -= 10;
    }
}

public class AnotherCar{
    private CarDriver driver;
    private int gear;
    private int velocity;

    // get, set, accelerate
    public boolean break(){
        if(this.velocity > 100){
            throw new RuntimeException("tooFast")
        
        }
    }
}

public class CarDriver{
    private String name;
    private int license;

    public CarDriver(String name, int license){
        this.name = name;
        this.license = license
    }
    // get, set, toString
}

```


문제 해결
```java
자동차가 공통적으로 수행해야할 기능
인터페이스를 따라간다면 모든 자동차가 인터페이스를 따라 만들고 대처가 가능해진다.
public interface CarInterface{
    void setDriver(Driver driver);
    void accelerate();
    void break();
}

인터페이스에 정의된 기능들을 모두 구현하여야 한다.
public class GoCart extends AbstractCar implements CarInterface{
    private Driver driver;
    private int velocity;

    void setDriver(Driver driver){
        this.driver = driver;
    }
    void accelerate(){
        this.velocity += 5;
    }
    void break(){
        this.velocity -= 5;
        super.break(); // abstract class의 velocity
    }
}

public class SmallCar implements CarInterface{
    private Driver driver;
    private int velocity;

    void setDriver(Driver driver){
        this.driver = driver;
    }
    void accelerate(){
        this.velocity += 5;
    }
    void break(){
        this.velocity -= 5;
    }
}

모든 자동차는 속도가 0보다 작아지면 속도가 0이 된다.
public abstract class AbstractCar implements CarInterface{
    protected int velocity;

    public void break(){
        if(this.velocity < 0) this.velocity = 0;
    }
}

두 가지의 자동차 모두 도로를 달릴 수 있다.
public class Road{
    private ArrayList<CarInterface> carOnRoad;


    public void addCar(CarInterface car){
        this.carsOnRoad.add(car);
    }
}

public class Driver{
    private String name;
    private int license;

    public Driver(String name, int license){
        this.name = name;
        this.license = license
    }
    // get, set, toString
}

public class Main{
    public static void main(String[] args){
        Driver unlicensed = new Driver(name : "unlicensed", license:0)
        Driver me = new Driver(name:"me", license: 1);
        CarInterface car = new GoCart();
        car.setDriver(me);
        
        car = new SmallCar();
        car.setDriver(me);
    }
}

```


Interface를 잘 활용하면 서로 다른 구현체가 같은 목적을 위해 동작하도록 만들 수 있다.  
사용하고자 하는 객체의 실제 자료형과 무관하게 동작하게 만들 수 있다.  
Java는 이미 Interface와 Abstract를 아주 잘 사용하고 있다.  
ex) ArrayList는 AbstractList를 extends하면서 List, RandomAccess,Cloneable, Serializable를 implements하고 있다.  

함수의 인자와 반환 값은 interface를 활용하자.  
return ArrayList x -> return List o  

InputStream의 구현체는 많지만 다 InputStream의 기능을 가지고 있다.
- InputStream을 필요로 하는 기능에는 구분없이 사용할 수 있다.

## Spring IoC Container와 DI
---

Spring의 가장 큰 기능 중 하나가 IOC Container
- Inversion of Control : 제어 역전, 면접 단골 질문
- 개발자 - SpringBoot
- 스프링 이전의 전통적인 개발, 라이브러리를 끌어와서 사용
- 프레임워크가 할일을 가지고 있고 개발자의 코드를 끌어와서 사용
- 즉, 제어가 역전되었다고 할 수 있다.  

IOC, 제어역전 : 프레임워크의 코드를 개발자가 사용하는 것이 아니라 개발자의 코드를 프레임워크가 사용하도록 제어가 역전되었다.  

IOC Contrainer : 코드와 설정정보를 합치는 것을 관리  
개발자 코드 + 설정 = Beans  

이미 존재하는 Beans을 필요한 시점에 사용하게 해주는 것이 Dependency Injection, DI  
Spring에서 구현을 요구하는 부분들을 interface로 정의  
이후 사용자가 정의한 구현체 Bean을 실제 서비스에 사용

## Spring과 Spring Boot의 차이
---

코드 + 설정 = Beans 객체  
Spring에서는 XML의 형태로 설정을 만들어 주었다.
- 따라서 입문하기가 매우 어려웠다. (XML을 잘 사용하기 위해서)
Spring에서는 실행을 위해 Tomcat과 같은 프로그램이 필요하다. (WAR 파일)  

Spring Boot에서는 Spring Boot Starter에 정의가 되어있다.  
Spring boot에서는 Tomcat 같은 서버 프로그램이 내장되어, Jar의 형태로 실행이 가능하다.  
하나의 파일로 




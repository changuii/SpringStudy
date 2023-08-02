package dev.chapter3_2.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping(
            value = "hello",    // 요청 URL의 PATH loaclhost:8080/hello
            method = RequestMethod.GET // HTTP GET메소드, URL주소로 문서를 가져오는 방식은 GET
    )
    public String hello(@RequestParam(name = "id", required = false, defaultValue = "") String id){  // 기본적인 Spring Boot에서 String은 경로를 돌려준다.
        logger.info("Path: Hello");
        logger.info("Query Param id :" + id);
        return "/hello.html";  // 만약 이 코드를 return "hello"로 한다면 hello의 요청의 반환값으로 다시 hello의 요청을 반환한다. 즉, 에러발생 (무한루프)

    }

    @GetMapping(    // 메소드가 GET으로 고정되어있다.
            value = "hello/{id}"   //

    )
    public String helloPath(@PathVariable("id") String id){
        logger.info("Path Variable is : "+ id);
        return "/hello.html";
    }

    @GetMapping(
            "/get-profile"
    )
    public @ResponseBody SamplePayload getProfile(){  // @ResponseBody를 사용하여 view를 찾는 것이 아니라 데이터를 Body로 사용한다. 사용하지 않으면 directory를 찾아 html을 반환
        return new SamplePayload("창의", 10,"develop" ); // 일반적인 자바 객체를 통용되는 데이터(JSON, XML) 형태로 전달해줄 수 있다.
    }

}

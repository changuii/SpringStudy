package com.example.HTML_Template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/rest")  // class에도 RequestMapping(디렉터리)를 작성가능.
public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);

    @PostMapping("/sample-payload")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void samplePayloadPost(@RequestBody SamplePayload samplePayload){
        logger.info(samplePayload.toString());
    }

    @PostMapping(
            value = "/sample-multipart",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sampleMultipartPost(
            @RequestParam("name") String name,
            @RequestParam("age") int age,
            @RequestParam("occupation") String occupation,
            @RequestParam("file")MultipartFile multipartFile){
        logger.info("in");
        logger.info("name: "+name);
        logger.info("age: "+age);
        logger.info("occupation: "+ occupation);
        logger.info("file original name: "+ multipartFile.getOriginalFilename());
    }

    @GetMapping("/sample-payload")
    public SamplePayload samplePayloadGet(){  // Controller는 기본적으로 view를 제공하거나 데이터를 제공하는 넓은 범위에서 사용하는 어노테이션이다.
        // RestController는 기본적으로 데이터를 제공하는 Controller이다. 따라서 ResqonseBody를 작성하지 않아도 잘 작동한다.
        return new SamplePayload("창의", 10,"develop" ); // 일반적인 자바 객체를 통용되는 데이터(JSON, XML) 형태로 전달해줄 수 있다.
    }

    @GetMapping(
            value = "/sample-image",
            produces = MediaType.IMAGE_PNG_VALUE  // MediaType 선택
    )
    public byte[] sampleImage() throws IOException {  // 이미지와 비디오는 기본적으로 다 byte로 구성되기 때문에 byte형태로 제공한다.
        InputStream inputStream = getClass().getResourceAsStream("/static/spring-boot.png");  // 들어오는 문자열을 resources 폴더 안에서 찾아간다.

        return inputStream.readAllBytes();
    }
}

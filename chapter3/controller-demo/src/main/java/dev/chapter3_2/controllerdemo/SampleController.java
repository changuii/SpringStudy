package dev.chapter3_2.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
    private static final Logger logger
            = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping()
    public String hello(){
        return "hello";
    }
}

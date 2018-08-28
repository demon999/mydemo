package com.xxx.boot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Richard on 14-8-26.
 */
@Controller
public class SampleController {

    @RequestMapping("/sample")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

}

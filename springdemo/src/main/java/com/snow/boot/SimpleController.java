package com.snow.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 14-6-24.
 */
@RestController
@EnableAutoConfiguration
public class SimpleController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleController.class,args);
    }
}

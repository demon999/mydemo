package com.snow.boot.sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Richard on 14-8-26.
 */
@RestController
public class HelloController {

    @RequestMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
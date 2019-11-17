package com.xxx.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Richard on 14-8-26.
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}

package com.xxx.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Richard Xue
 * @version 1.0
 * @date 05/26/2015
 * @description
 */
@RestController
@RequestMapping
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}

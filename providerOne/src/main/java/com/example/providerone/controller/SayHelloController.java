package com.example.providerone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sayHello
 *
 * @author xiaobai
 * @date 2020/4/26
 */
@RestController
public class SayHelloController {
    @RequestMapping("/sayHello")
    public String sayHello() {
        return "Hello, I am provider one";
    }
}

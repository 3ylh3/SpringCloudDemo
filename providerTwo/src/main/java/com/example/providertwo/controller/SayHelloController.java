package com.example.providertwo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author yin_zhj
 * @date 2020/4/27
 */
@RestController
public class SayHelloController {

    @RequestMapping("/sayHello")
    public String sayHello() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        return "Hello, I am provider two";
    }
}

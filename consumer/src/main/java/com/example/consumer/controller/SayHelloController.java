package com.example.consumer.controller;

import com.example.consumer.service.SayHelloService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private SayHelloService sayHelloService;

    @RequestMapping("/sayHello")
    public String sayHello() {
        return sayHelloService.sayHello();
    }
}

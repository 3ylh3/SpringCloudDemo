package com.example.consumer.service.impl;

import com.example.consumer.service.SayHelloService;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author yin_zhj
 * @date 2020/6/10
 */
@Component
public class FallBackImpl implements SayHelloService {
    @Override
    public String sayHello() {
        return "System busy,please wait a minute";
    }
}

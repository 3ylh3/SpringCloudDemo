package com.example.consumer.service;

import com.example.consumer.service.impl.FallBackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 *
 * @author yin_zhj
 * @date 2020/4/27
 */
@FeignClient(value = "service-provider", fallback = FallBackImpl.class)
public interface SayHelloService {
    @RequestMapping("/sayHello")
    public String sayHello();
}

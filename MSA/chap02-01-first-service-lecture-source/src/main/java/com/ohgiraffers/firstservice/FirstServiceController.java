package com.ohgiraffers.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//@RequestMapping("/first-service")  // 게이트 웨이에서 filter 이용해 자르기
@RequestMapping("/")
public class FirstServiceController {

    @GetMapping("health_check")
    public String healthCheck(){
        return "I'm OK";
    }

    @GetMapping("message")
    public String message(@RequestHeader("first-request") String header){
        log.info("넘어온 헤더값: {}", header);
        return "First Service Message";
    }

}

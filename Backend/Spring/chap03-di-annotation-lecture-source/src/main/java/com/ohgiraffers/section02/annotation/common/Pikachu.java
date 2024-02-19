package com.ohgiraffers.section02.annotation.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary      // 같은 종류 여러개인 경우에 우선순위 높음 -> 두개 이상 붙일 경우 에러
public class Pikachu implements Pokemon{
    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트⚡");
    }
}

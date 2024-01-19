package com.ohgiraffers.section03.interface_implements;

import java.io.Serializable;

public class Product implements InterProduct, Serializable {    // 인터페이스는 다중구현(다중상속 개념)이 가능하다.
    @Override
    public void nonStaticMethod() {
        System.out.println("InterProduct nonStaticMethod 오버라이딩 메소드 호출");
    }

    @Override
    public void nonStaticMethod2() {

    }

    @Override
    public void defaultMethod() {        // 상속받아 오버라이딩 시에는 default 키워드 빼야함
        System.out.println("product에서 물려받아 오버라이딩한 defaultMethod 호출");
    }
}

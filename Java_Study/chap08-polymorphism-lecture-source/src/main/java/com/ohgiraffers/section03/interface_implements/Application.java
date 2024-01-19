package com.ohgiraffers.section03.interface_implements;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. 인터페이스에 대해 이해할 수 있다. */
        /* 필기
         *  인터페이스란?
         *  자바의 클래스와 유사한 형태지만
         *  추상 메소드(public abstract)와 상수 필드(public static final)만 가질 수 있는 클래스의 변형체
        * */

        /* 설명. ** 추상클래스와 인터페이스의 차이는 면접 단골 질문 ** */
//        InterProduct ip = new InterProduct();  // 생성자가 없는 인터페이스는 객체생성X
        InterProduct ip = new Product();         // 다만 타입으로 활용이 가능 -> 다형성 가능(타입 은닉)


    }
}

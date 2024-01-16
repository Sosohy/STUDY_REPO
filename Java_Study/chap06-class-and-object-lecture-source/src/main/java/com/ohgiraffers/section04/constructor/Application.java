package com.ohgiraffers.section04.constructor;

public class Application {

    /* 수업목표. 생성자 함수가 무엇인지 이해하고 선언 및 호출할 수 있다. */

    public static void main(String[] args) {

        User user = new User();       // 생성자 함수 -> 객체 생성 시 필요한 함수 | 객체가 heap 영역에 생성됨
        System.out.println(user.forInformation());

        User user2 = new User("user2", "pw2", "유저2", new java.util.Date());
        System.out.println(user2.forInformation());
    }
}

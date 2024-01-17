package com.ohgiraffers.section04.constructor;

public class Application {

    /* 수업목표. 생성자 함수가 무엇인지 이해하고 선언 및 호출할 수 있다. */

    public static void main(String[] args) {

        /* 필기
         *  생성자란?
         *   인스턴스를 생성할 때 호출하는 반환형이 없는 함수로
         *   기본생성자와 매개변수 있는 생성자로 나눌 수 있다.
        * */

        /* 기본생성자(매개변수 없는)를 활용한 객체 생성 */
        User user = new User();       // 생성자 함수 -> 객체 생성 시 필요한 함수 | 객체가 heap 영역에 생성됨
        System.out.println(user.forInformation());

        /* 매개변수 있는 생성자를 활용한 객체 생성 */
        User user2 = new User("user2", "pw2", "유저2", new java.util.Date());
        //System.out.println(user2.forInformation());
    }
}

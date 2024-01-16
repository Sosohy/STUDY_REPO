package com.ohgiraffers.section02.encapsulation.problem2;

public class Application {

    /* 수업목표. 필드값 수정 시 발생할 수 있는 문제점을 이해할 수 있다. */
    public static void main(String[] args) {

//        Monster m1 = new Monster();
//        m1.name = "드라큘라";
//        m1.hp = 200;
//        m1.print();


        Monster m2 = new Monster();
        m2.setInfo1("프랑켄슈타인");
        m2.setInfo2(200);
    }

}

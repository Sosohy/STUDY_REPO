package com.ohgiraffers.section03.math;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. Math 클래스에서 제공하는 static 메소드를 호출할 수 있다. */

        /* 목차 1. 절대값 출력 */
        System.out.println(Math.abs(-32.1));

        /* 목차 2. 최대값, 최소값 출력 */
        System.out.println("큰 값 : " + Math.max(10, 20));
        System.out.println("작은 값 : " + Math.min(10, 20));

        /* 목차 3. 난수 생성 */
        System.out.println(Math.random());

    }
}

package com.ohgiraffers.section02.package_and_import;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 패키지에 대해 이해할 수 있다. */

        /* 목차 1. non-static 메소드 호출 */
        com.ohgiraffers.section01.method.Calculator cal1 = new com.ohgiraffers.section01.method.Calculator();

        int plusResult = cal1.plusNum(100, 20);
        System.out.println(plusResult);

        /* 목차 2. static 메소드 호출 */
        int maxResult = com.ohgiraffers.section01.method.Calculator.maxNum(100, 20);
        System.out.println(maxResult);

    }
}

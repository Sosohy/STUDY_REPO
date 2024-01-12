package com.ohgiraffers.section02.package_and_import;
import com.ohgiraffers.section01.method.Calculator;
public class Application2 {

    public static void main(String[] args) {

        /* 수업목표. import에 대해 이해할 수 있다. */

        /* 목차 1. non-static 메소드의 경우 */
        Calculator cal = new Calculator();
        int subResult = cal.subNum(80, 21);
        System.out.println(subResult);

        /* 목차 2. static 메소드의 경우 */
        System.out.println("큰 값 : " + Calculator.maxNum(80, 21));
    }
}

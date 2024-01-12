package com.ohgiraffers.section01.method;

public class Application9 {

    public static void main(String[] args) {

        /* 수업목표. 다른 클래스에 작성한 메소드를 호출할 수 있다. */

        int first = 100;
        int second = 50;

        Calculator cal = new Calculator();
        System.out.println("두 수의 합 = " + cal.plusNum(first, second));          // non-static 메소드 호출
        System.out.println("두 수의 차 = " + cal.subNum(first, second));
        System.out.println("두 수의 곱 = " + cal.multiNum(first, second));
        System.out.println("두 수를 나눈 결과 = " + cal.divideNum(first, second));
        System.out.println("큰 값 = " + Calculator.maxNum(first, second));        // static 메소드는 클래스명.을 붙여 호출한다.
        //System.out.println("작은 값 = " + cal.minNum(first, second));           // 접근제어자 따라서 다른 클래스에서 접근 못할 수도 있다.
    }
}

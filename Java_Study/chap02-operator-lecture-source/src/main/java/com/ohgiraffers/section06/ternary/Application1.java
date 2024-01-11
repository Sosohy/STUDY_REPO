package com.ohgiraffers.section06.ternary;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 삼항연산자에 대해 이해하고 활용할 수 있다. */
        /* 필기
         *  삼항 연산자
         *   자바에서 유일하게 피연산자 항목이 3개인 연산자이다.
         *   (조건식) ? 참일 때 사용할 값1 : 거짓일 때 사용할 값2
        * */

        /* 목차 1. 삼항연산자 단독 사용 */
        int num1 = 10;
        int num2 = -10;
        String result1 = (num1 > 0) ? "양수" : "양수가 아님";
        String result2 = (num2 > 0) ? "양수" : "양수가 아님";
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("==========================================");

        /* 목차 2. 삼항연산자 중첩 사용 */ // 중첩은 안 쓰는 게 좋음
        int num3 = -1;
        int num4 = 0;
        int num5 = 1;
        String result3 = (num3 > 0) ? "양수" : (num3 == 0) ? "0" : "음수";
        String result4 = (num4 > 0) ? "양수" : (num4 == 0) ? "0" : "음수";
        String result5 = (num5 > 0) ? "양수" : (num5 == 0) ? "0" : "음수";
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);
        System.out.println("result5 = " + result5);

    }
}

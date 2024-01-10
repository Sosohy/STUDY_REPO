package com.ohgiraffers.section01.literal;

public class Application1 {
    public static void main(String[] args) {

        // 수업목표 여러가지 값의 형태를 출력할 수 있다.

        // 목차 1. 숫자 형태의 값 출력
        // 목차 1-1. 정수 형태의 값 출력
        System.out.println(123);

        // 목차 1-2. 실수 형태의 값 출력
        System.out.println(1.234);

        // 목차 2. 문자 형태의 값 출력
        System.out.println('a');         // 문자는 single quatation(') 적용, 문자는 문자 하나만 가능
        System.out.println('1');         // 숫자도 '' 안에서는 문자 취급
        // System.out.println('abcd');   // 문자열 X -> 문자열 들어가면 컴파일 에러(문법 오류)
        System.out.println('\u0000');    // 아무 문자도 안 넣을거면 \u0000

        //목차 3. 문자열 형식의 값 출력
        System.out.println("문자열");      // 문자열은 double quatation(") 적용
        System.out.println("a");         // 문자열은 문자 하나도 가능
        System.out.println("");          // 아무 문자도 안 넣은 문자열 가능

        // 목차 4. 논리 형태의 값 출력
        System.out.println(true);        // "true" 붙으면 문자열
        System.out.println(false);       // true 또는 false 두 값만 논리값

    }
}

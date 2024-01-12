package com.ohgiraffers.section01.method;

public class Application8 {

    public static void main(String[] args) {

        /* 수업목표. static 메소드를 호출할 수 있다. */
        System.out.println(sumNums(10, 20));     //Application8.sumNums(10, 20); 호출하는 메소드가 같은 클래스면 생략 가능
    }

    private static int sumNums(int first, int second) {
        return first + second;
    }

}

package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class D_doWhile {
    public void testSimpleDoWhileStatement() {

        /* 수업목표. 단독 do-while문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */
        do{
            System.out.println("기본 실행");
        }while(false);

        System.out.println("반복 종료");
    }

    public void testDoWhileExample() {

        /* 수업목표. do-while문의 흐름을 이해하고 적용할 수 있다. */
        Scanner sc = new Scanner(System.in);
        String str = "";
        boolean flag = false;
        do{
            if(str != "" && str != "finish"){
                System.out.println("finish를 입력");
            }
            System.out.print("finish를 입력하면 종료 : ");
            str = sc.nextLine();
            System.out.println(str + "를 입력하셨습니다.");
        }while(!str.equals("finish"));          // str문자열 값이 "finish"와 일치하면 false 되도록

        System.out.println("반복문 종료");
    }
}

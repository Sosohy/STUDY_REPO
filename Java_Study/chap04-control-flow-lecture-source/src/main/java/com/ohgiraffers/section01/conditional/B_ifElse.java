package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class B_ifElse {


    public void testSimpleIfElseStatement() {

        /* 수업목표. if-else문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 하나 입력하세요 : ");
        int num = sc.nextInt();

        if (num % 2 != 0) {
            System.out.println("입력한 정수는 홀수입니다.");
        } else {
            System.out.println("입력한 정수는 짝수입니다.");
        }

    }

    public void testNestedIfElseStatement() {

        /* 수업목표. 중첩된 if-else문의 흐름을 이해하고 적용할 수 있다. */
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 하나 입력하세요 : ");
        int num = sc.nextInt();

        /* 설명. 정수를 하나 입력받아서 양수와 음수를 구분하고 양수일 때만 짝수인지 아닌지 판별 */
        if (num > 0) {                              // 양수일 때
            if (num % 2 == 0) {
                System.out.println("양수/짝수");     // 양수이면서 짝수
            } else {
                System.out.println("양수/홀수");     // 양수이면서 홀수
            }
        } else {                                   // 0 또는 음수
            System.out.println("0 또는 음수");
        }
    }
}

package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwoToNine() {

        /* 수업목표. 중첩된 for문의 흐름을 이해하고 적용할 수 있다. */

        /* 설명
         *  2 * 1 = 2
         *  2 * 2 = 4
         *  2 * 3 = 6
         *  ...
         *  9 * 7 = 63
         *  9 * 8 = 72
         *  9 * 9 = 81
        *  */

        for (int i = 2; i <= 9; i++) {          // 단수

            System.out.println(i + "단 ------------------------------");
            for (int j = 1; j <= 9; j++) {      // 곱해지는 수
                System.out.println(i + " * " + j + " = " + (i*j));
            }
            System.out.println();
        }

    }

    public void printUpgradeGugudan() {

        /* 수업목표. inner for문을 메소드로 따로 모듈화 -> 하나의 기능 단위로 보고 */
        for (int i = 2; i < 10; i++) {
            System.out.println(i + "단 -----------------------");
            printGugudanOf(i);
            System.out.println();
        }
    }

    /* 필기. 단수를 넘기면 1~9까지 곱해서 숫자 출력 */
    private void printGugudanOf(int i) {
        for (int j = 0; j < 10; j++) {
            System.out.println(i + " * " + j + " = " + (i*j));
        }
    }

    public void printStars() {
        /* 설명
         *  아래와 같은 별모양이 나오도록 작성
         *       *
         *      **
         *     ***
         *    ****
         *   *****
        *  */

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for (int i = 1; i <= input; i++) {
            /* 공백 출력용 */
            printSpace(input-i);
//            for (int j = 1; j <= input-i; j++) {
//                System.out.print(" ");
//            }
            /* star 출력용 */
            printStar(i);
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*");
//            }
            System.out.println();
        }
    }

    public void printStars2(){

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for (int i = 1; i <= input*2; i+=2) {
            int none = 0;
            int star = 0;

            if(i <= input){
                none = (input-i)/2;
                star = i;
            }else{
                none = (input-(input*2-i))/2;
                star = input*2-i;
            }

            for (int j = 1; j <= none; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= none; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void printStar(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
            }
    }

    private void printSpace(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.print(" ");
        }
    }
}

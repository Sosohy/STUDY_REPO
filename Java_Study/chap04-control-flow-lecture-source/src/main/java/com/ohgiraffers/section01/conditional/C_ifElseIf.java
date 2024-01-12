package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class C_ifElseIf {
    public void testSimpleIfElseIfStatement() {

        /* 수업목표. if-else-if문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */
        System.out.println("산 속에서 나무를 하던 나무꾼이 연못에 도끼를 빠뜨리고 말았다.");
        System.out.println("연못에서 산신령이 나타나 금도끼, 은도끼, 쇠도끼를 들고 나타났다.");
        System.out.println("나무꾼에게 셋 중 어떤 도끼가 나무꾼의 도끼인지 물어보았다.");

        System.out.print("어느 도끼가 너의 도끼이냐? (1. 금도끼, 2. 은도끼, 3. 쇠도끼) : ");

        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();

        if (answer == 1) {
            System.out.println("거짓말쟁이에게 줄 도끼는 없다ㅡㅡ");
        } else if (answer == 2) {
            System.out.println("거짓말쟁이,,,ㅡㅡ");
        } else {                    // answer == 3
            System.out.println("금도끼, 은도끼, 쇠도끼 다 가져가라~");
        }

        System.out.println("산신령은 다시 연못 속으로 사라졌다...✨");
    }

    public void testNestedIfElseIfStatement() {

        /* 수업목표. 중첩된 if-else-if문의 흐름을 이해하고 적용할 수 있다. */
        /* 필기
         *  ohgiraffers대학의 김XX교수님은 학생들 시험성적을 수기로 계산해서 학점 등급을 매기는 채점방식을 사용하고 있다.
         *  90점 이상이면 'A' 80점 이상이면 'B', 70점 이상이면 'C', 60점 이상이면 'D', 60점 미만 'F'
         *  학생의 이름과 점수를 입력하면 학점등급이 계산되는 프로그램 만들기
         *  (추가로, 각 등급의 중간점수(95, 85, 75...) 이상인 경우 '+' 붙여서 등급 세분화하기)
         * */

        Scanner sc = new Scanner(System.in);

        System.out.print("학생 이름 : ");
        String name = sc.nextLine();
        System.out.print("점수: ");
        int score = sc.nextInt();
        String grade;

        if (score <= 100 && score >= 0) {

            if (score >= 90) {
                grade = "A";
            } else if (score >= 80) {
                grade = "B";
            } else if (score >= 70) {
                grade = "C";
            } else if (score >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            if ((!grade.equals("F") && score % 10 >= 5) || score == 100) {
                grade += "+";
            }

            System.out.println(name + " 학생의 점수는 " + score + "점이고, 등급은 " + grade + "입니다.");
            System.out.println("프로그램을 종료합니다.");

        } else {
            System.out.println("입력값이 올바르지 않음");
        }
    }
}

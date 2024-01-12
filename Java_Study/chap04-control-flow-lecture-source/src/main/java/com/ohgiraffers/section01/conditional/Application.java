package com.ohgiraffers.section01.conditional;

/* 이제부터 실행용 클래스 구분해 사용 -> main 메소드 포함 */
public class Application {

    public static void main(String[] args) {

        A_if aClass = new A_if();

        /* 단독 if문 */
//        aClass.testSimpleStatement();

        /* 중첩 if문 */
//        aClass.testNestedIfStatement();


        B_ifElse bClass = new B_ifElse();

        /* 단독 if-else문  */
//        bClass.testSimpleIfElseStatement();

        /* 중첩 if-else문 */
//        bClass.testNestedIfElseStatement();

        C_ifElseIf cClass = new C_ifElseIf();

        /* 단독 if-else-if문 */
//        cClass.testSimpleIfElseIfStatement();

        /* 중첩 if-else-if문 */
        cClass.testNestedIfElseIfStatement();

        /* 중첩 if-else-if문 로직 개선 */
//        cClass.testSimpleIfElseIfStatement();
    }
}

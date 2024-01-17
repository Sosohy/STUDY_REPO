package com.ohgiraffers.section06.statickeyword;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. static 키워드에 대해 이해할 수 있다. */
        /* 필기
         *  static
         *  프로그램이 실행될 때 정적 메모리 영역(static 영역 또는 클래스 영역)에 할당
         *  여러 인스턴스가 공유해서 사용할 목적의 공간이다.
         *  대표적인 예로 singleton 객체가 있다.
        * */

        /* 목차 1. static 키워드를 필드에서 사용 */
        StaticFieldTest sft = new StaticFieldTest();

        /* 설명. 현재 두 필드가 가지고 있는 값 확인 */
        System.out.println("non-static field : " + sft.getNonStaticCount());
        System.out.println("static field : " + StaticFieldTest.getStaticCount());

        /* 각 필드값 하나씩 증가 */
        sft.increaseStaticMethodCount();
        sft.increaseNonStaticMethodCount();

        /* 두 필드 값 확인 */
        System.out.println("non-static field : " + sft.getNonStaticCount());
        System.out.println("static field : " + StaticFieldTest.getStaticCount());

        /* 새로운 객체 생성 */
        StaticFieldTest sft1 = new StaticFieldTest();
        System.out.println("non-static field : " + sft1.getNonStaticCount());
        System.out.println("static field : " + StaticFieldTest.getStaticCount());


    }
}

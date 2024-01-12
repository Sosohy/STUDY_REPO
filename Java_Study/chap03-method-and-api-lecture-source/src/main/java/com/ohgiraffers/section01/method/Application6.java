package com.ohgiraffers.section01.method;

public class Application6 {

    public static void main(String[] args) {

        /* 수업목표. 반환값이 있는 메소드 테스트해보기 */
        System.out.println("--main() 동작--");

        Application6 app6 = new Application6();
        String returnText = app6.testMethod();
        System.out.println(returnText);

        /* 설명. 굳이 변수에 담을 필요없이 메소드의 반환값을 한번만 사용할 거라면 바로 호출해서 반환값을 활용할 수 있다. */
        // "return값 : " + app6.testMethod() -> 표현식(하나의 리터럴로 치환될 식)
        System.out.println("return값 : " + app6.testMethod());

        System.out.println("--main() 종료--");
    }

    private String testMethod() {
        System.out.println("testMethod() 실행");
        return "testMethod() 실행 끝";
    }
}

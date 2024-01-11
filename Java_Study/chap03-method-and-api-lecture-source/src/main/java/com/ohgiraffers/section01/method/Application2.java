package com.ohgiraffers.section01.method;

public class Application2 {

    /* 수업목표. 메소드의 호출 흐름에 대해 이해할 수 있다.(main 메소드에서 한 번에 순차적으로 여러 메소드 호출)*/

    public static void main(String[] args) {

        System.out.println("main() 시작");

        // static이 붙어 있지 않은 메소드는 <클래스명 변수명 = new 클래스명();> 활용해 객체 생성 후 메소드 호출
        Application2 app2 = new Application2();
        app2.methodA();

        methodB();
        methodC();
        System.out.println("main() 종료");
    }

    public void methodA(){
        System.out.println("methodA() 호출");
        System.out.println("methodA() 종료");
    }

    public static void methodB(){
        System.out.println("methodB() 호출");
        System.out.println("methodB() 종료");
    }

    public static void methodC(){
        System.out.println("methodC() 호출");
        System.out.println("methodC() 종료");
    }

}

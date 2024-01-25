package com.ohgiraffers.section02.enumtype;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. 열거형(Enum)을 이용하여 상수 열거 패턴의 단점을 해결하는 것을 이해할 수 있다. */
        /* 설명 1. 열거 타입으로 선언된 인스턴스는 싱글톤으로 관리되며 **인스턴스가 한 개 임을 보장**한다.
        *         -> 순서 개념의 인덱스가 아니라 인스턴스임 */
        Subjects subjects1 = Subjects.JAVA;
        Subjects subjects2 = Subjects.HTML;
        Subjects subjects3 = Subjects.JAVA;

        if(subjects1 == subjects2){
            System.out.println("같은 과목");
        }else{
            System.out.println("다른 과목");
        }

        /* 설명 2. 단일 인스턴스임을 보장하기에 == 비교가 가능하다. */
        if(subjects1 == subjects3){
            System.out.println("싱글톤");
        }
        System.out.println("==========================");

        /* 설명 3. toString()/name() 이용해서 필드명을 문자열로 변경하기 쉽다. (switch문 사용하지 않고) */
        System.out.println(Subjects.JAVA.toString());   // toString()은 커스텀 가능
        System.out.println(Subjects.JAVA.name());
        System.out.println("==========================");

        /* 설명 4. values()를 이용해서 상수값 배열을 반환받고 이를 이용하여 연속처리할 수 있다. */
        Subjects[] subjects = Subjects.values();
        for(Subjects s : subjects){
            System.out.println(s.toString());
            System.out.println(s.ordinal());
            System.out.println(s.name());
        }

        /* 설명 5. 타입 안전을 보장할 수 있다. */
        printSubjects(Subjects.JAVA);
//        printSubjects(0);              // Subjects 타입이 아니라서 에러 발생
    }

    private static void printSubjects(Subjects subjects) {
    }
}

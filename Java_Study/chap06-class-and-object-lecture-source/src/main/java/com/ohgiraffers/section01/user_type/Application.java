package com.ohgiraffers.section01.user_type;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. 클래스가 무엇인지 이해하고 작성할 수 있다. */
        /* 설명.
         *  회원 정보를 관리하기 위해 회원의 여러 정보(아이디, 비번, 이름, 나이, 성별, 취미)를 취급하여 관리하려고 한다.
         *  이 자료를 취급할 수 있는 방법을 생각해보자.
        * */

        /* 목차 1. 변수를 이용한 회원 데이터 관리 */
        String id = "user01";
        String pw = "pass01";
        String name = "name1";
        int age = 20;
        char gender = '여';
        String[] hobby = {"축구", "뮤지컬", "클라이밍"};

        System.out.println("id = " + id);
        System.out.println("pw = " + pw);
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("gender = " + gender);
        System.out.println("hobby = " + Arrays.toString(hobby));

        /* 필기
         *  변수들로만 관리할 때 발생할 수 있는 문제점
         *  1. 많은 변수명들을 관리하기 힘들 수 있다.
         *  2. 메소드의 전달인자로 전달할 값이 너무 많아 회원과 관련된 기능을 호출할 때 매개변수가 많아진다.
         *  3. 메소드의 반환형으로 회원이라는 개념을 반환할 수 없다.(메소드 반환형은 하나여야 하기 때문에)
        * */

        Member member1 = new Member();
        Member member2 = new Member();  //new Member("id1", "pw1", "name1", 20, '여', hobby);

        member1.name = "김철수";
        member2.name = "김영희";

        /* member1 완성하기 */
        member1.age = 20;
        member1.gender = '남';
        member1.hobby = new String[]{"클라이밍", "축구"};
        member1.id = "chKim";
        member1.pw = "chKimPw";

        /* 회원정보를 하나의 전달인자로 전달하고 하나의 매개변수로 받을 수 있다. */
        /* 또한 메소드의 반환형으로 한번에 회원 정보를 반환할 수 있고 반환 받은 곳에서 반환된 객체에 접근도 가능 */
        Member renameM = print(member1);
        System.out.println(member1.name);
        System.out.println(renameM.name);
        System.out.println(renameM.age);

    }

    private static Member print(Member member) {
        System.out.println("개명하기");
        member.name = "박길동";

        return member;
    }
}

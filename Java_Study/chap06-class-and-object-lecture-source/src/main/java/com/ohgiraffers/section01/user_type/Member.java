package com.ohgiraffers.section01.user_type;

public class Member {

    /* 설명. 여러가지 타입의 값을 하나의 타입(Member 클래스)으로 묶음 -> c++의 구조체에 가까움 */
    String id;
    String pw;
    String name;
    int age;
    char gender;
    String[] hobby;

    public Member(String id, String pw, String name, int age, char gender, String[] hobby) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
    }

    public Member() {
    }
}

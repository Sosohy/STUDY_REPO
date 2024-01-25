package com.ohgiraffers.section02.enumtype;

public enum Subjects {
    JAVA,           // 0
    MARIADB,        // 1
    JDBC,           // 2
    HTML,           // 3
    CSS,            // 4
    JAVASCRIPT;     // 5 // 마지막 필드 이후에 생성자 같은 거 생성하려면 세미콜론 필수

    Subjects() {    // 필드마다 객체 생성함
        System.out.println("기본 생성자 호출");
    }

    @Override
    public String toString() {
        return "***" + this.name() + "***";
    }
}

package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class User {
    private String id;
    private String pw;
    private String name;
    private java.util.Date enrollDate;

    public User(){         // 생성자 함수 (클래스 명과 똑같음, 반환값 없음)
        System.out.println("User 객체 생성");
    }

    public User(String id, String pw, String name, Date enrollDate) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.enrollDate = enrollDate;
    }

    public String forInformation(){
        return this.id + " " + this.pw + " " + this.name + " " + this.enrollDate;
    }
}

package com.ohgiraffers.section03.filterstream.dto;

import java.io.Serializable;

/* 설명. MemberDTO 타입의 객체를 객체단위 입출력(Object 관련 스트림)을 하기 위해서는 Serializable 인터페이스를 구현해야 한다. */
public class MemberDTO implements Serializable {
    private String id;

    /* 설명. transient 키워드가 붙은 필드는 직렬화에서 제외된다. */
    private /*transient*/ String pw;       // transient : 직렬화 제외
    private  String name;
    private  String email;
    private  int age;
    private char gender;

    public MemberDTO() {
    }

    public MemberDTO(String id, String pw, String name, String email, int age, char gender) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

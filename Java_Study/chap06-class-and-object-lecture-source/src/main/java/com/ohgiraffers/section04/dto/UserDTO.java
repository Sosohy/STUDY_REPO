package com.ohgiraffers.section04.dto;

import java.util.Date;

/* 필기
 *  자바빈(Java Bean) 이란 ?
 *  JSP에서 배우게 될 표준 액션 태그로 접근할 수 있게 만든 자바 클래스
 *  자바 코드를 모르는 웹 퍼블리셔들도 자바 코드를 사용할 수 있도록 태그 형식으로 지원하는 문법을 의미하는데,
 *  그때 사용할 수 있도록 규칙을 지정해 놓은 java 클래스를 자바빈이라고 한다.
 *  지금은 특정 목적에 따라 클래스를 작성하는 규칙이라고 보면 된다.
* */

/* 필기.
 *  자바빈 작성 규칙
 *  1. 자바빈은 특정 패키지에 속해있어야 함 -> default 패키지 사용 금지
 *  2. 필드의 접근제어자는 private 선언해야 함
 *  3. 기본 생성자가 명시적으로 존재해야 한다. (매개변수 생성자는 선택사항)
 *  4. 모든 필드에 접근 가능한 설정자(setter)와 접근자(getter)가 public 작성되어 있어야 함
 *  5. 직렬화(Serializable)를 고려해야 한다 (선택사항)
* */

public class UserDTO {           // Data Transfer Object

    /* 필기. 1. 필드(멤버변수) */
    private String id;
    private String pw;
    private String name;
    private java.util.Date enrollDate;

    /* 필기 2. 생성자 (기본 생성자 필수로 명시적 작성) */
    public UserDTO() {
    }

    public UserDTO(String id, String pw, String name, Date enrollDate) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.enrollDate = enrollDate;
    }

    /* 필기 3. 설정자(setter)와 접근자(getter) */
    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    /* getter, setter 단축키로 생성 */

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

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

//    public String forInformation(){
//        return this.id + " " + this.pw + " " + this.name + " " + this.enrollDate;
//    }

    /* 필기  4. 모든 멤버 변수를 String으로 반환하는 toString() */
    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}

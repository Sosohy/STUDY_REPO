package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class User {
    private String id;
    private String pw;
    private String name;
    private java.util.Date enrollDate;

    /* 필기
     *  생성자 작성 위치
     *  작성 위치는 문법상으로 클래스 내부에 필드 선언부 이후, 메소드 선언부 이전에 작성하는 것이 관례.
    * */
    public User(){         // 생성자 함수 (클래스 명과 똑같음, 반환값 없음)
        System.out.println("User 객체 생성");
    }

    /* 생성자와 같은 클래스 내부에 거의 필수적으로 들어가는 요소를 생성하는 단축키는 alt+insert */
    public User(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public User(String id, String pw, String name, Date enrollDate) {

        /* 필기. 생성자 안의 this. 은 해당 생성자를 통해 생성될 객체에 접근하는 것  */
        /* 필기. 일반적으로  필드의 변수명과 매개변수명이 동일하므로 반드시 this. 명시해야 함*/
        /* 필기. 생성자 안의 this()는 해당 클래스의 다른 생성자를 사용하는 것  / 하나의 다른 생성자만 사용 가능 */
//        this.id = id;
//        this.pw = pw;
//        this.name = name;
//        this();                         // this()를 통한 다른 생성자 활용은 하나의 다른 생성자만 사용 가능
        this(id, pw, name);               // this() -> 다른 생성자 가리킴
        this.enrollDate = enrollDate;
//        this(id, pw, name);             // this()는 반드시 먼저 명시 되어야 한다.


        System.out.println("user 필드 초기화");
        System.out.println(this.forInformation());
    }

    public String forInformation(){
        return this.id + " " + this.pw + " " + this.name + " " + this.enrollDate;
    }
}

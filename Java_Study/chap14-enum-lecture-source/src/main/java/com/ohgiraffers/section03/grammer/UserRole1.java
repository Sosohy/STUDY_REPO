package com.ohgiraffers.section03.grammer;

public enum UserRole1 {
    GUEST,
    CONSUMER,
    PRODUCER,
    ADMIN;

    /* 필기
     *  생성자를 가질 수 있다.
     *  다만 생성자는 외부에서 사용하지 못하도록(싱글톤 패턴)
     *  default 또는 private만 사용 가능
     *  enum 타입은 고정된 상수들의 집합이며 한 번 할당된 객체는 변하지 않는다.
    * */
    UserRole1() {    // 생성자는 default/private만 가능
        System.out.println("기본 생성자");
    }

    /* 설명. 필요한 경우 메소드도 추가할 수 있다. */
    public String getNameToLowerCase(){
        return this.name().toLowerCase();
    }
}

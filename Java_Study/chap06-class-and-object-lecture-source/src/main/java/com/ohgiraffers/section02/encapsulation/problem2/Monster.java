package com.ohgiraffers.section02.encapsulation.problem2;

public class Monster {

//    String name;
//    int hp;

    /* 필드의 변수명이 바뀌었을 경우 */
    String kinds;
    int mp;

    void setInfo1(String info1){
//        this.name = info1;
        this.kinds = info1;
    }

    void setInfo2(int info2){
//        this.hp = info2;
        this.mp = info2;
    }

//    public void print(){
//        System.out.println("몬스터의 이름 : " + this.name);
//        System.out.println("몬스터의 체력 : " + this.hp);
//        System.out.println();
//    }
}

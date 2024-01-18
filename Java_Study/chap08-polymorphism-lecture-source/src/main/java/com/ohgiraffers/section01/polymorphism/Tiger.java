package com.ohgiraffers.section01.polymorphism;

public class Tiger extends Animal{

    @Override
    public void eat(){
        System.out.println("냠냠🐯");
    }

    @Override
    public void run() {
        System.out.println("어슬렁🐅");
    }

    @Override
    public void cry() {
        System.out.println("어흥🐯") ;
    }

    public void bite(){
        System.out.println("호랑이 앙🐯");
    }
}

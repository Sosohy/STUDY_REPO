package com.ohgiraffers.section01.polymorphism;

public class Rabbit extends Animal{

    @Override
    public void eat(){
        System.out.println("냠냠🐰");
    }

    @Override
    public void run() {
        System.out.println("춉춉🐰");
    }

    @Override
    public void cry() {
        System.out.println("끼악🐰");
    }

    public void jump(){
        System.out.println("깡총🐇");
    }
}

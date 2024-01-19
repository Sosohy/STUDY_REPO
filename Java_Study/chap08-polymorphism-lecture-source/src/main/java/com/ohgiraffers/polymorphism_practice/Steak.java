package com.ohgiraffers.polymorphism_practice;

public class Steak extends Cook {

    int level;

    public Steak() {
    }

    public Steak(String name, String[] ingredients, int cookTime) {
        super(name, ingredients, cookTime);
    }
    public Steak(String name, String[] ingredients, int cookTime, int level) {
        super(name, ingredients, cookTime);
        this.level = level;
    }

    @Override
    public void setDish() {
        System.out.println("가니쉬, 찍어먹을 소스 같이 준비하기");
    }

    @Override
    public void cooking() {
        System.out.println("스테이크 미디엄레어로 굽기");
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + " | 스테이크 냠냠👩‍🍳🥩");
    }

    public void prepareMeat(){
        System.out.println("고기에 올리브유와 소금 뿌려서 준비하기");
    }

    @Override
    public String toString() {
        return "Steak{" +
                "level=" + level +
                "} " + super.toString();
    }
}

package com.ohgiraffers.polymorphism_practice;

public class Pasta extends Cook {

    public Pasta() {
    }

    public Pasta(String name, String[] ingredients, int cookTime) {
        super(name, ingredients, cookTime);
    }

    @Override
    public void setDish() {
        System.out.println("파스타 접시에 담고 파슬리 뿌리기");
    }

    @Override
    public void cooking() {
        System.out.println("삶은 면 꺼내서 파스타 소스와 함께 조리하기");
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + " | 파스타 냠냠👩‍🍳🍝");
    }

    public void prepareNoodles(){
        System.out.println("파스타 면 삶기");
    }

    public void choiceSource(){
        System.out.println("파스타 소스 준비하기");
    }

    @Override
    public String toString() {
        return "Pasta{} " + super.toString();
    }
}

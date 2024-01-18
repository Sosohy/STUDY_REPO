package com.ohgiraffers.section01.polymorphism;

public class Application4 {

    public static void main(String[] args) {

        /* 수업목표. 다형성을 적용하여 리턴타입에 활용할 수 있다. */
        Application4 app4 = new Application4();
        Animal radomAnimal = app4.getRadomAnimal();
        radomAnimal.cry();
    }

    private Animal getRadomAnimal() {

        int random = (int)(Math.random()*2);    // 0~1 난수 생성

        return random == 0 ? new Tiger() : new Rabbit();

    }
}

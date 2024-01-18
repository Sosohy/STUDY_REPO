package com.ohgiraffers.section01.extend;

public class RacingCar extends Car{

    public RacingCar() {
        System.out.println("-- RacingCar() 기본 생성자 호출 --");
    }

    @Override
    public void run() {
        System.out.println("레이싱카 달립니다. 부아아아아아아아아ㅏ앙");
    }

    @Override
    public void soundHorn() {
        System.out.println("레이싱카 경적 놉");
    }
}

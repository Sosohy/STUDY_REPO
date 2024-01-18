package com.ohgiraffers.section01.extend;

public class Car {

    /* 설명. 자동차의 속성과 기능 나열 */
    private boolean runningStatus;

    public Car() {
//        super();         // Object 클래스 나옴
        System.out.println("-- Car() 기본 생성자 호출 --");
    }

    public void run(){
        runningStatus = true;
        System.out.println("자동차가 달리기 시작합니다.");
    }

    public void stop(){
        runningStatus = false;
        System.out.println("자동차가 멈췄습니다.");
    }

    public void soundHorn(){
        if(isRunning()){
            System.out.println("빵-빵-");
        }else{
            System.out.println("주행 중이 아닐 때는 경적을 울릴 수 없습니다!.!");
        }
    }

    public boolean isRunning(){
        return runningStatus;
    }

}

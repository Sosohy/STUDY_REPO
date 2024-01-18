package com.ohgiraffers.section01.extend;

public class FireCar extends Car {

    public FireCar() {
//        super();                                        // 부모의 기본 생성자 -> 생략해도 자동으로 호출
        System.out.println("-- FireCar() 기본 생성자 호출 --");
    }

    @Override
    /* 필기
     *  @Override 추가하는 이유?
     *  1. 메소드 중에 부모로부터 물려받은 메소드인것을 한 눈에 알아보기 쉽게 하기 위해(가독성)
     *  2. 부모의 메소드를 오버라이딩할 때 발생할 수 있는 실수를 방지하기 위해(실수방지 측면)
    * */

    public void soundHorn() {                            // 부모의 메소드 재정의 -> 오버라이딩
        System.out.println("빵빠아ㅏ아앙아ㅏ아아빵아아아아-");
    }

    public void sprayWater(){
        System.out.println("불난 곳 향해 물 뿌리기 =========3");
    }
}

package com.ohgiraffers.section03.abstraction;

public class CarRacer {

    private Car myCar = new Car();

    /* 시동이 걸려있지 않은 경우 시동 걸기 */
    public void startUp() {
        myCar.startUp();            // == this.myCar.startUp();
    }

    /* 시동이 걸린 상태인 경우에만 10km/h씩 속도 증가 */
    public void stepAccelator() {
        myCar.go();
    }

    /* 시동이 걸려있고 달리는 상태인 경우 멈추기 */
    public void stepBreak() {
        myCar.stop();
    }

    /* 시동이 걸려있는 상태인 경우에 시동 끄기, 주행 중이라면 끌 수 없음 */
    public void turnOff() {
        myCar.turnOff();
    }
}

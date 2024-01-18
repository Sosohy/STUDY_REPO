package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Computer extends Product{
    private  String cpu;               // 연산장치
    private int hdd;                   // 하드
    private  int ram;                  // 램
    private String operationSystem;    // 운영체제

    public Computer() {
        super();
        System.out.println("computer 기본 생성자");
    }

    public Computer(String cpu, int hdd, int ram, String operationSystem) {
        super();
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operationSystem = operationSystem;
        System.out.println("computer클래스의 모든 필드 초기화하는 생성자 호출");
    }

    public Computer(String code, String brand, String name, int price, Date manufaturingData, String cpu, int hdd, int ram, String operationSystem) {
        super(code, brand, name, price, manufaturingData);
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operationSystem = operationSystem;
        System.out.println("computer클래스의 부모 필드까지 초기화하는 생성자 호출");
    }

    @Override
    public String toString() {
//        return "Computer{" +
//                "cpu='" + cpu + '\'' +
//                ", hdd=" + hdd +
//                ", ram=" + ram +
//                ", operationSystem='" + operationSystem + '\'' +
//                "} " + super.toString();     // 부모꺼는 자신의 클래스에 있지는 않으니까 super.getCode() 또는 getCode() 이런 식으로 받아와야 함
//                                             // 메소드는 물려받아서 this.getCode()/getCode() 만도 사용가능

        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", hdd=" + hdd +
                ", ram=" + ram +
                ", operationSystem='" + operationSystem + '\'' +
                "} " +
                "Product{" +
                "code='" + super.getCode() + '\'' +
                ", brand='" + super.getBrand() + '\'' +
                ", name='" + this.getName() + '\'' +
                ", price=" + getPrice() +
                ", manufaturingData=" + this.getManufaturingData() +
                '}';
    }
}

package com.ohgiraffers.section02.abstractclass;

public class SmartPhone extends Product{

    public SmartPhone() {
//        super();
    }

    /* 설명. 추상메소드를 물려받은 자식 클래스(온전한 클래스롤 만들 경우)는 반드시 오버라이딩 해야 한다. -> 강제성 부여 */
    @Override
    public void abstractMethod() {
        System.out.println("Product 클래스로부터 물려받은 메소드를 오버라이딩한 메소드 호출");
    }
    
    /* 설명. 추가적인 메소드도 작성 가능 */
    public void printSmartPhone(){
        System.out.println("printSmartPhone 호출");
    }
}

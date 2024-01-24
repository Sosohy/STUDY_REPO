package com.ohgiraffers.section01.exception;

public class ExceptionTest {


    public void checkEnoughMoney(int price, int money) throws Exception {
        System.out.println("현재 가지고 있는 돈 : " + money);

        if(money >= price){
            System.out.println(price + "원 상품 구매 가능");
        }else{               // 예외 상황
            throw new Exception("잔액부족 오류");
        }
    }
}

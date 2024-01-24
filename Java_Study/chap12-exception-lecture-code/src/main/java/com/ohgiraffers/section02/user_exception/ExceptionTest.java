package com.ohgiraffers.section02.user_exception;

import com.ohgiraffers.section02.user_exception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.user_exception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.user_exception.exception.PriceNegativeException;

public class ExceptionTest {

    public void checkEnoughMoney(int price, int money) throws Exception //PriceNegativeException, MoneyNegativeException, NotEnoughMoneyException
    {

        /* throw를 통한 예외 발생 시 바로 메소드를 호출한 곳으로 예외 인스턴스와 함께 반환된다. */
        if(price < 0){
            throw new PriceNegativeException("상품 가격은 음수일 수 없습니다.");
        }

        if(money < 0){
            throw new MoneyNegativeException("가진 돈이 음수일 수 없습니다.");
        }

        if(money < price){
            throw new NotEnoughMoneyException("가진 돈보다 상품 가격이 더 비쌉니다.");
        }

        System.out.println("상품 구매 가능");
    }
}

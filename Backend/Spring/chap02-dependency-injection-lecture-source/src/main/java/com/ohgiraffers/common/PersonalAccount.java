package com.ohgiraffers.common;

public class PersonalAccount implements Account{

    private final int bankCode;
    private final String accNo;
    private int balance;

    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    @Override
    public String getBalance() {
        return this.accNo + "의 현재 잔액은 " + this.balance + "원";
    }

    @Override
    public String deposit(int money) {
        String str = "";

        if(money >= 0){
            this.balance += money;
            str = money + "원 입금";
        }else{
            str = "잘못된 금액";
        }

        return str;
    }

    @Override
    public String withDraw(int money) {
        String str = "";

        if(this.balance >= money){
            this.balance -= money;
            str = money + "원 출금";
        }else{
            str = "계좌 잔액 부족";
        }

        return str;
    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "bankCode=" + bankCode +
                ", accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}

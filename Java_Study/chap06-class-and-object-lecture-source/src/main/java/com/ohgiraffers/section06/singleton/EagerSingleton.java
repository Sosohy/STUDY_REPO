package com.ohgiraffers.section06.singleton;

public class EagerSingleton {

    private static  EagerSingleton eager = new EagerSingleton();

    private EagerSingleton() {    // 외부에서 객체 생성X
    }

    public static EagerSingleton getInstance(){
        return eager;
    }
}

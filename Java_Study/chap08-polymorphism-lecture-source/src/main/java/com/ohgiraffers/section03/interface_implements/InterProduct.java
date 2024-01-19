package com.ohgiraffers.section03.interface_implements;

/* 설명. 인터페이스 간에는 다중 상속이 가능하고, implements 대신 extends 사용 */
public interface InterProduct extends ParentInterProduct, AnotherParentInterProduct {

    /* 설명. 상수 필드만 가질 수 있기 때문에 모든 필드는 묵시적으로 public static final이다. */
    int MAX_NUM = 100;   // public static final int MAX_NUM = 100;

    /* 설명. 인터페이스는 생성자를 가질 수 없다. */
//    public InterProduct(){}

    /* 추상메소드만 작성이 가능하다 (public abstract) */
//    private void nonStatic();
    public abstract void nonStaticMethod();
    void nonStaticMethod2();   // 자동으로 public abstract 붙여줌

    /* 설명. 하지만 static 메소드는 바디부까지 작성을 허용한다.(jdk 1.8부터  추가) */
    public static void staticMethod(){
        System.out.println("interProduct의 staticMethod 호출");
    }

    /* 설명. 또한 default 키워드를 사용하면 non-static 메소드로 작성 가능하다.(jdk 1.8부터  추가)*/
    public default void defaultMethod(){
        privateMethod();
        System.out.println("interProduct의 defaultMethod 호출");
    }

    /* 설명. private도 abstract가 아닌 온전한 메소드로 사용은 가능하다. (default 없이) */
    private void privateMethod(){
        System.out.println("private");
        /* 설명. 다른 public default 메소드에서 활용할 수만 있는 메소드 */
    }

}

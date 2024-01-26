package com.ohgiraffers.section07.initblock;

public class Product {
    private String name;            // 상품명
    private int price;              // 상품가격
    private static String brand;    // 제조사

    /* 설명. 생성자를 통한 객체 생성 전에 알고리즘을 적용해야 할 일이 있다면 초기화 블럭을 활용할 수 있다. */

    {
        name = "싸이언";
        brand = "LG";
        System.out.println("초기화 블럭 실행");
    }

    /* 설명. static 초기화 블럭은 static 변수만 초기화가 가능하며 다른 초기화 블럭보다 먼저 실행된다. */
    static {
        brand = "엘지";
//        name = "new";        // static 변수가 아니기 때문에
    }

    public Product() {
        System.out.println("기본생성자 실행");
    }

    public Product(String name) {
        this.name = name;
        System.out.println("product 매개변수 1개 생성자 실행");
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brand=" + Product.brand +
                '}';
    }
}

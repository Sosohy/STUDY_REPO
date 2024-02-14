package com.ohgiraffers.section02.initdestroy;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames){
            System.out.println("beanName = " + beanName);
        }

        /* 붕어빵, 딸기우유, 지리산암반수 빈 객체를 반환 받아 변수에 담는다. */
        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        /* 첫번째 손님이 쇼핑 카트를 꺼내 물건을 담는다. */
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        /* 첫번째 손님의 쇼핑 카트에 담긴 물품 확인 */
        System.out.println("cart1.getItems() = " + cart1.getItems());

        /* 두번째 손님이 쇼핑 카트를 꺼내 물건을 담는다 */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);
        System.out.println("cart2.getItems() = " + cart2.getItems());

        System.out.println(System.identityHashCode(cart1) == System.identityHashCode(cart2));

        /* main 메소드 종료 전(application 종료 전)에 의도적으로 container를 소멸(bean들도 소멸) */
        ((AnnotationConfigApplicationContext)context).close();
    }
}

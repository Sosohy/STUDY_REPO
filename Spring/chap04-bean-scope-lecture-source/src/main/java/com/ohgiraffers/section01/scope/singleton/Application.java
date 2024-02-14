package com.ohgiraffers.section01.scope.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    /* 설명
     *  bean scope?
     *  스프링 빈이 생성될 때 해당 인스턴스의 범위를 의미한다. 스프링에서는 다양한 bean scope를 제공한다.
     *  1. Singleton : 하나의 인스턴스를 생성하고, 모든 빈이 해당 인스턴스를 공유하여 사용한다.
     *  2. Prototype : 매번 새로운 인스턴스를 생성한다.
     *  3. Request : Http 요청을 처리할 때마다 새로운 인스턴스를 생성하고, 요청 처리가 끝나면 인스턴스를 폐기한다.
     *               웹 애플리케이션 인스턴스에만 해당된다.
     *  4. Session : Http 세션 당 하나의 인스턴스를 생성하고, 세션이 종료되면 인스턴스를 폐기한다.
     *               웹 애플리케이션 컨텍스트에만 해당된다.
     *  5. GlobalSession : 전역 세션 당 하나의 인스턴스를 생성하고, 전역 세션이 종료되면 인스턴스를 폐기한다.
     *                포털 애플리케이션 컨텍스트에만 해당된다.
    * */
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

    }
}

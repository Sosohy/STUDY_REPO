package com.ohgiraffers.section01.contextlistener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {

    public ContextListener() {

        /* context가 생성될 때 변화를 담지하는 listener 인스턴스가 함께 생성 */
        System.out.println("contextListener 인스턴스 생성");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        /* context에 attribute가 추가될 때 동작 */
        System.out.println("contextListener added");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        /* context에 attribute가 제거될 때 동작 */
        System.out.println("contextListener removed");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        /* context에 attribute가 변경될 때 동작 */
        System.out.println("contextListener replaced");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* context가 생성될 때 생성자 호출이후 동작하는 메소드 */
        System.out.println("contextListener initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* context가 소멸될 때 동작하는 메소드 */
        System.out.println("contextListener destroyed");
    }
}

package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");


        MemberService memberService = context.getBean("memberService", MemberService.class);

        System.out.println("============ select all members ===========");
        List<MemberDTO> members = memberService.findAllMembers();
        members.forEach(System.out::println);

        System.out.println("\n============ select one member ===========");
        System.out.println(memberService.findMemberBy(1));

        /* 2번 인덱스에 해당하는 회원 조회(AfterThrowing Advice 확인용) */
//        System.out.println("\n============ select one member(AfterThrowing) ===========");
//        System.out.println(memberService.findMemberBy(3));

    }
}

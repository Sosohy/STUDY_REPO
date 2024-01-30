package com.ohgiraffers.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. stream에 대해 이해하고 활용할 수 있다. */
        /* 필기
         *  Arrays.asList() : 매개변수로 요소들을 전달하면 List로 변환
         *  ArrayList<>(Collection 타입) : Collection 타입을 ArrayList 객체로 생성할 때 쓰이는 생성자
        * */
        List<String> stringList = new ArrayList<>(Arrays.asList("hello", "world", "stream"));

        System.out.println("======for each=======");
        for(String str : stringList){
            System.out.println(str);
        }

        System.out.println("=======stream=======");
        stringList.forEach(System.out::println);             // :: 참조연산자
        stringList.forEach((a) -> System.out.println(a));    // Consumer 타입만 들어갈 수 있음(리턴 없어야 함)
    }
}

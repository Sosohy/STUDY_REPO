package com.ohgiraffers.section01.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application2 {

    public static void main(String[] args) {

        /* 수업목표. 스트림의 병렬처리에 대해 이해할 수 있다. */
        List<String> stringList = new ArrayList<>(Arrays.asList("java", "oracle", "jdbc", "html", "css"));

        /* 설명. main 스레드에서 스트림을 사용하지 않고 확인 */
        System.out.println("======for each======");
        for (String str : stringList){
            System.out.println(str + " : " + Thread.currentThread().getName());
        }

        System.out.println("======normal stream======");
        stringList.forEach(Application2::print);

        /* 설명. 병렬 스트림 사용시 스레드 확인 (속도가 상대적으로 몇 배 더 빠르다. 또한 기본 main스레드 외에 다른 스레드를 활용한다.)*/
        System.out.println("=======parallel stream======");
        stringList.parallelStream().forEach(Application2::print);
    }

    private static void print(String str) {
        System.out.println(str + " : " + Thread.currentThread().getName());
    }
}

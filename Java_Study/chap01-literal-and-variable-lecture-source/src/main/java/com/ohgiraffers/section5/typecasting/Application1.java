package com.ohgiraffers.section5.typecasting;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 자동 형변환(implicit coercion) 규칙에 대해 이해할 수 있다. */


        /* 설명. 점점 더 큰 자료형으로 데이터를 옮겨도 문제 없이 자동형변환 되어 대입이 이루어 진다. */
        byte bnum = 1;                   // 리터럴이 정수일 때 자바는 int로 받아들이지만
                                         // int -> byte, int -> short는 자동 형변환됨(다운 캐스팅 해줌)
        short snum = bnum;               // (short)bnum
        int inum = snum;
        long lnum = inum;

        /* 설명. 연산 시에도 자동으로 큰 쪽 자료형에 맞춰 낮은 자료형이 자동형변환 된다. */
        int num1 = 10;
        long num2 = 20L;

        long result = num1 + num2;
        System.out.println(result);

        /* 설명. 문자형은 int형으로 자동 형변환 된다.(그 반대도 가능) */
        int ch1 = 'a';
        int charNum = ch1;
        System.out.println(ch1 + " | " +charNum);

        char ch2 = 65;
        System.out.println(ch2);

    }
}

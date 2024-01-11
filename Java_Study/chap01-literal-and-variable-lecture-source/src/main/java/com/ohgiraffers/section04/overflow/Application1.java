package com.ohgiraffers.section04.overflow;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 오버플로우에 대해 이해할 수 있다. */

        /* 필기
         *  자료형 별 값의 최대 범위를 벗어나는 경우
         *  발생한 carry를 버림처리하고 sign bit를 반전시켜 최소값으로 순환시킴
        * */

        /* 목차 1. 오버플로우 */
        byte num1 = 127;                                 // byte 자료형의 양의 최대 저장 범위 값
        System.out.println("num1 = " + num1);

        num1++;
        System.out.println("num1 = " + num1);

        num1++;
        System.out.println("num1 = " + num1);

        num1++;
        System.out.println("num1 = " + num1);
        System.out.println("====================================================");

        /* 목차 2. 언더플로우 */
        byte num2 = -128;                                // byte 자료형의 음의 최대 저장 범위 값
        System.out.println("num2 = " + num2);

        num2--;
        System.out.println("num2 = " + num2);

        num2--;
        System.out.println("num2 = " + num2);

        num2--;
        System.out.println("num2 = " + num2);
        System.out.println("====================================================");

        /* 설명.
         *  일반적으로 많이 사용하는 int형의 최대값은 대락 21억 정도.
         *  이 범위를 벗어난 계산은 오버플로우를 발생시켜 원하지 않는 결과값이 나오게 될 수 있다.
        * */

        int firstNum = 1000000;
        int secNum = 700000;

        int multi = firstNum * secNum;                   // 7천억 나와야 함
//        int multi2 = 1000000 * 700000;                 // 숫자로 넣으면 오버플로우 발생한다고 경고 띄움

        System.out.println("first+second = " + multi);   // -79669248 나옴
    }
}

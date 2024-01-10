package com.ohgiraffers.section01.literal;

public class Application2 {
    public static void main(String[] args){

        // 수업목표 : 값을 직접 연산하여 출력할 수 있다.

        // 목차 1. 숫자와 숫자의 연산
        System.out.println("=========정수와 정수의 연산=========");
        System.out.println(123 + 456);
        System.out.println(123 - 23);
        System.out.println(123 * 10);
        System.out.println(123 / 10);
        System.out.println(123 % 10); // mod -> 제수로 나눈 나머지

        System.out.println("=========실수와 실수의 연산=========");
        System.out.println(1.23 + 1.23);
        System.out.println(1.23 - 0.23);
        System.out.println(1.23 * 10.0);
        System.out.println(1.23 / 10.0);
        System.out.println(1.23 % 1.0);        // 실수는 정확하지 않고 근사값이다. ->    비슷한데 정확하게는 안나올수도

        // 필기 : 정수는 실수로 변환돼서 실수끼리 연산됨 -> 결과는 실수로 나옴
        System.out.println("=========정수와 실수의 연산=========");
        System.out.println(123 + 0.5);
        System.out.println(123 - 0.5);
        System.out.println(123 * 0.5);
        System.out.println(123 / 0.5);
        System.out.println(123 % 0.5);


        // 목차 2. 문자의 연산
        // 필기  문자와 정수의 연산은 정수와 정수의 연산과 같다. -> 문자는 유니코드 기반의 숫자로 변환
        System.out.println("=========문자와 정수의 연산=========");
        System.out.println('a' + 1); // 98 -> a == 97
        System.out.println('a' - 1); // 96
        System.out.println('a' * 2); // 194
        System.out.println('a' / 2); // 48
        System.out.println('a' % 2); // 1


        System.out.println("=========문자와 실수의 연산=========");
        // 필기 문자와 실수의 연산은 정수와 실수의 연산과 같다.

        // 목차 3. 문자열의 연산
        System.out.println("=========문자열과 문자열의 연산=========");
        System.out.println("hi" + "sohye");    // 문자열 간의 연산은 덧셈만 가능 -> 문자열 이어붙이기
//        System.out.println("hi" - "sohye");
//        System.out.println("hi" * "sohye");
//        System.out.println("hi" / "sohye");
//        System.out.println("hi" % "sohye");

        System.out.println("=========문자열과 다른 형태의 값 연산=========");  // 문자열과 문자열의 연산이 된다.
        // 설명. 문자열과 정수의 연산
        System.out.println("hi" + 123);

        // 설명. 문자열과 실수의 연산
        System.out.println("hi" + 123.456);

        // 설명. 문자열과 문자의 연산
        System.out.println("hi" + 'a');

        // 설명. 문자열과 논리값의 연산
        System.out.println("hi" + true);

        // 설명. 좌측에서부터 이항씩 연산하면 아래 코드 결과 : (123+3)연산(int) -> 126 + "hello" -> 이때부터는 문자열 형식임
        System.out.println(123+3+"hello"+123+3); // 126hello1233

        // 문자열 뒤에 숫자 활용한 연산 하려면 우선순위 높이고 연산하기
        System.out.println(123+3+"hello"+30/3);  // 126hello10
        System.out.println("합계 : " + (123+345)); // 합계 : 468

        // 목차 4. 논리값의 연산
        // 설명. 대부분의 연산이 적용되지 않고, 논리와 문자열의 연산만 가능
        // System.out.println(true+1); // true가 1로 변환되지 않음

        System.out.println("=========논리값과 문자열 연산=========");
        System.out.println("hi" + true);
    }
}

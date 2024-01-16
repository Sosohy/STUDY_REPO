package com.ohgiraffers.section01.array;

public class Application2 {

    public static void main(String[] args) {

        /* 수업목표. 배열의 사용 방법을 익혀 배열을 사용할 수 있다. */
        /* 필기.
         *  배열의 사용 방법
         *  1. 배열의 선언
         *  2. 배열의 할당
         *  3. 배열의 인덱스 공간에 값 대입
        * */

        int[] iArr;
//        char cArr[];        // 대괄호 변수명 뒤에 붙여도 되지만 권장되지X
//        iArr = new int[];   // 크기를 반드시 할당해야 함
        iArr = new int[10];

        char[] cArr = new char[5];

        /* 필기. 참조자료형 변수 출력 결과 = 자료형@진수주소값 */
        System.out.println("iArr = " + iArr);
        System.out.println("cArr = " + cArr);

        /* hashcode 통해 10진수 주소값도 확인 가능 */
        System.out.println("iArr = " + iArr.hashCode());
        System.out.println("cArr = " + cArr.hashCode());

        /* null값을 지닌 참조 자료형 변수(아무것도 참조하지 않을 때) 접근 시 발생하는 에러 확인 */
        cArr = null;
//        System.out.println("null 참조할 시 " + cArr.hashCode());



    }
}

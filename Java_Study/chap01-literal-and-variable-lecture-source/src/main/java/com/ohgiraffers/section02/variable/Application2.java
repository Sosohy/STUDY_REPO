package com.ohgiraffers.section02.variable;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표 : 변수를 선언하고 값을 할당하여 사용할 수 있다. (feat.자료형(type)) */
        /* 필기.
         *  변수를 사용하는 방법
         *  1. 변수를 준비한다. (선언)
         *  2. 변수에 값을 대입한다. (값 대입 및 초기화)
         *  3. 변수를 사용한다.
        * */

        /* 목차 1. 변수 선언 */
        /* 설명. 자료형이란?
         *  다양한 값의 형태별로 어느 정도의 크기를 하나의 값으로 취급할 것인지 미리 Compiler와 약속한 키워드
         *  이러한 자료형은 기본자료형(Primitive Type)과 참조자료형(Reference Type)으로 나누어짐
        *  */

        /* 기본 자료형 */
        /* 정수를 취급하는 자료형 */
        byte bnum;          // 1byte
        short snum;         // 2byte
        int inum;           // 4byte
        long lnum;          // 8byte

        /* 실수를 취급하는 자료형 */
        float fnum;         // 4byte
        double dnum;        // 8byte

        /* 문자를 취급하는 자료형 */
        char ch;            // 2byte

        /* 논리값을 취급하는 자료형 */
        boolean isTrue;     // 1byte

        /* 설명. 문자열은 참조 자료형이다. (Feat. 대문자로 시작) */
        String str;         // 4byte -> 모든 참조 자료형은 4byte

        /* 목차 2. 변수에 값 대입 (초기화) */
        bnum = 1;           // 정수 default는 int -> (byte)1로 들어가는 셈(자동형변환 해줌)
        snum = 2;
        inum = 4;
        lnum = 2200000000L; // 숫자커져서(21억 이상은 int로 볼 수 없어서) L 안붙이면 오류남

        fnum = 4.0f;        // 실수형 default는 double이라서 f 안붙이면 자동형변환 안해줌
        dnum = 8.0;

        ch = 'a'+1;
        ch = 97;            // char 자료형은 문자를 숫자로 취급
        //ch = -97;         // char 자료형은 0부터 양수만 취급
        isTrue = false;


        /* 목차 3. 변수 활용 */
        System.out.println("bnum = " + bnum);
        System.out.println("lnum + inum = " + (lnum+inum));    // long 타입으로 바뀜
        System.out.println("fnum = " + fnum);
        System.out.println("ch = " + ch);
        System.out.println("isTrue = " + isTrue);

        /* 설명. 변수의 선언 및 초기화는 한 번에 가능 */
        int kor = 90;
        int math = 80;
        int eng = 75;

        int sum = kor + math + eng;
        double avg0 = sum/3; // sum/3 하면 int형끼리 나눠져서 int로 결과 나오고 형변환 돼서 소수점 이하 안나옴
        double avg = sum/3f; // 나눗셈을 할 때는 소수점을 고려해야 함 -> 하나라도 float 또는 double 형이어야 함

        System.out.println("종합 : " + sum);
        System.out.println("평균 : " + avg);

    }
}

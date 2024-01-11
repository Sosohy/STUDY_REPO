package com.ohgiraffers.section5.typecasting;

public class Application2 {

    public static void main(String[] args) {

        /* 수업목표. 강제 형변환 규칙에 대해 이해할 수 있다. */
        /* 필기
         *  강제형변환
         *  바꾸려는 자료형으로 캐스트 연산자(자료형)를 이용하여 형변환한다.
        * */

        long lnum = 80000000000L;
        int inum = (int)lnum;             // 명시적 형변환 -> 데이터 손실을 감수하고 다운캐스팅 시에는 주의해야 한다.
        System.out.println(inum);


        float avg = 31.235f;
        int floorAvg = (int)avg;         // 실수 -> 정수 다운캐스팅 시에는 소수점 이하가 날아감
        System.out.println(floorAvg);

    }
}

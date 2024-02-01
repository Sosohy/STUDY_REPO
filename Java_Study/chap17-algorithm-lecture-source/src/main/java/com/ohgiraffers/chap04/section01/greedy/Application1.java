package com.ohgiraffers.chap04.section01.greedy;

public class Application1 {

    public static Integer solution(int n){
        int count = 0;             // 들고 갈 최소 봉지 갯수

        while (true){

            /* 설명. 5kg 봉지로 바로 나눌 수 있으면 n/5 반환 */
            if (n % 5 == 0) {
                return (n / 5) + count;              // +count의 개념은 이전 반복에서 가져가야 할 3kg 봉지의 수
            }else if(n < 0) {
                return -1;
            }

            /* 설명. 3kg 봉지로 한 봉지 들고 간다. */
            n -= 3;
            count++;
        }
    }
}

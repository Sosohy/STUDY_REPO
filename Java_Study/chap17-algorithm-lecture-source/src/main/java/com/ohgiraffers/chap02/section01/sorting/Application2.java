package com.ohgiraffers.chap02.section01.sorting;

import java.util.Scanner;

/* 수업목표. 선택 정렬을 이해할 수 있다. */
/* 필기
 *  선택 정렬(Selection Sort)
 *  대상 데이터에서 최대나 최소 데이터를 찾아 맨 앞(또는 맨 뒤)와 교환하는 방법이다.
 *  배열의 모든 요소에 대해 반복한다.
 *  시간 복잡도는 O(n^2)라 효율적이지는 않다.
* */
public class Application2 {

    /* 설명.
     *  문제 내용
     *   : N개의 정수가 주어졌을 때, 선택 정렬 알고리즘을 사용하여 내림차순으로 정렬하는 프로그램을 작성하시오.
     *  입력
     *   - 첫 번째 줄에 자연수 N(1 <= N <= 100)이 주어진다.
     *   - 두 번째 줄에 N개의 정수가 공백으로 구분되어 입력된다. 각 정수는 -10^9 이상, 10^9 이하이다.
     *  출력
     *    - 내림차순으로 정렬된 수열을 공백으로 구분하여 출력한다.
     *
     * 설명.
     *  예시 입력 1
     *    - 10
     *      32 7 34 39 40 41 22 31 23 25
     *  예시 출력 1
     *    - 41 40 39 34 32 31 25 23 22 7
     *
     * 설명.
     *  예시 입력 2
     *    - 6
     *      42 29 34 64 28 12
     *  예시 출력 2
     *    - 64 42 34 29 28 12
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* 입력 데이터 받기 */
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();               // 공백을 구분자로 하여 하나씩 입력 됨
        }
//        System.out.println(Arrays.toString(arr));

        /* 알고리즘 실행 */
        solution(arr);

        /* 정렬 결과 출력 */
        for (int i : arr){
            System.out.print(i + " ");
        }

    }

    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int maxIdx = i;

            /* j범위에서 가장 큰 값을 maxIdx에 저장 */
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    maxIdx = j;
                    int tmp = arr[i];
                    arr[i] = arr[maxIdx];
                    arr[maxIdx] = tmp;
                }
            }
        }
    }

}

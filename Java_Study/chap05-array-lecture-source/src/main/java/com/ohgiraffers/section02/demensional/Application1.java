package com.ohgiraffers.section02.demensional;

import java.util.Arrays;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 다차원 배열의 구조를 이해하고 사용할 수 있다. */
        /* 필기.
         *  다차원 배열
         *  다차원 배열은 2차원 이상의 배열을 의미한다.(일반적으로는 사람의 인지 범위에 맞게 최대 3차원 정도를 고려한다.)
        * */

        int[][] iArray1;                                  // int[] iArray[], int iArray[][] 가능하지만 추천X
        iArray1 = new int[3][2];                          // 정변 배열을 위한 선언 방식(관리하는 1차원 배열의 길이가 동일할 경우)
        int[][] iArray2 = new int[3][];                   // 가변배열을 위한 선언 방식(관리하는 1차원 배열의 길이가 다를 경우)
//        iArray1 = new int[][];                          // 아무것도 할당 안하면 컴파일 에러남

        /* 설명. 정변 배열은 이미 1차원 배열들이 생성되어 지정되어 있다. */
        int num = 0;
        for (int i = 0; i < iArray1.length; i++) {        // 1차원 배열을 고르는 for문
            for (int j = 0; j < iArray1[i].length; j++) { // 선택된 1차원 배열의 길이만큼 반복하는 for문
                iArray1[i][j] = num++;
            }
            System.out.println(Arrays.toString(iArray1[i]));
        }

        int length = 1;
        /* 설명. 가변 배열은 아직 1차원 배열들이 생성되어 있지 않다.(1차원 배열 할당 안하면 컴파일 에러남) */
        for (int i = 0; i < iArray2.length; i++) {
            iArray2[i] = new int[++length];
            for (int j = 0; j < iArray2[i].length; j++) {
                iArray2[i][j] = num++;
            }
            System.out.println(Arrays.toString(iArray2[i]));
        }
    }
}

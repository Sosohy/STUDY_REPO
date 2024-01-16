package com.ohgiraffers.section02.demensional;

import java.util.Arrays;

public class Application2 {

    public static void main(String[] args) {
        int[][] iArr1 = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        int[][] iArr2 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};

        /* 설명. Arrays.toString 활용한 출력 */
        for (int i = 0; i < iArr1.length; i++) {
            System.out.println(Arrays.toString(iArr1[i]));
        }

        System.out.println("==================================================");

        /* 설명. 2차원 배열 출력 커스터마이징 활용 */
        for (int i = 0; i < iArr2.length; i++) {
            for (int j = 0; j < iArr2[i].length; j++) {
                System.out.print("iArr2[" + i + "][" + j + "] = " + iArr2[i][j] + " ");
            }
            System.out.println();
        }

    }
}

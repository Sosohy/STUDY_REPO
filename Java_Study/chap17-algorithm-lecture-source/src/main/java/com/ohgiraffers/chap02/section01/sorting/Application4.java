package com.ohgiraffers.chap02.section01.sorting;

import java.util.Scanner;

public class Application4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        solution(0, arr.length-1, arr);

        for (int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void solution(int lo, int hi, int[] arr) {
        if(lo >= hi){
            return;
        }

        int pivot = process(lo, hi, arr);
        solution(lo, pivot, arr);
        solution(pivot + 1, hi, arr);
    }

    /* 설명. lo에 해당하는 포인터와 hi에 해당하는 포인터를 최대한 움직여 pivot을 반환하는 메소드 */
    private static int process(int left, int right, int[] arr) {
        int lo = left - 1;
        int hi = right + 1;
        int pivot = arr[(left+right)/2];
        while (true){

            /* 설명. pivot 위치에 있는 값보다 작은 값을 가리키면 lo포인터를 증가시킨다. */
            do{
                lo++;
            }while (arr[lo] < pivot);

            /* 설명. pivot 위치에 있는 값보다 크면서 lo포인터의 위치보다 크거나 같은 위치이면 계속 감소한다. */
            do{
                hi--;
            }while (arr[hi] > pivot && lo <= hi);

            /* 설명. lo포인터의 위치가 hi포인터를 앞지르려고(같거나 크면) 하면 hi 위치를 반환한다. -> 분할 기준 반환 */
            if(lo >= hi){
                return hi;
            }
            swap(arr, lo, hi);
        }
    }

    /* 설명. 전달된 배열과 인덱스들을 바탕으로 위치를 swap하는(바꾸는) 메소드 */
    private static void swap(int[] arr, int lo, int hi) {
        int tmp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = tmp;
    }
}

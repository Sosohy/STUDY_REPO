package com.ohgiraffers.chap02.section01.sorting;

/* 수업목표. 병합 정렬을 이해할 수 있다. */
/* 필기
 *  병합 정렬(Merge Sort)
 *  데이터를 분할하고 분할한 집합을 정렬해서 합치는 방식(분할 정복 방식)으로 정렬한다.
 *  시간 복잡도는 O(logn)이다.
* */
public class Application5 {
    public static void solution(int low, int high, int[] arr){
        int[] tmp = new int[high+1];

        if(high-low == 0) return;
        int mid = low + (high - low) / 2;

        solution(low, mid, arr);
        solution(mid+1, high, arr);

        /* 설명. 정렬 전 tmp에 배열 복사 */
        tmp = arr.clone();

        /* 설명. 분할 정복 방식으로 작은 값부터 값을 쌓음 */
        int k = low;
        int idx1 = low;
        int idx2 = mid + 1;

        /* 설명. 두 인덱스가 가리키는 값들을 비교하고 하나라도 분할 구역의 끝을 만나면 멈추는 반복문 실행 */
        while(idx1 <= mid && idx2 <= high){
//            if(tmp[idx1] > tmp[idx2]){      // 오름차순
            if(tmp[idx1] < tmp[idx2]){        // 내림차순
                arr[k] = tmp[idx2];
                idx2++;
            }else{
                arr[k] = tmp[idx1];
                idx1++;
            }
            k++;
        }

        /* 설명. 좌측 인덱스 마저 옮기기 */
        while(idx1 <= mid){
            arr[k] = tmp[idx1];
            k++;
            idx1++;
        }

        /* 설명. 우측 인덱스 마저 옮기기 */
        while(idx2 <= high){
            arr[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}

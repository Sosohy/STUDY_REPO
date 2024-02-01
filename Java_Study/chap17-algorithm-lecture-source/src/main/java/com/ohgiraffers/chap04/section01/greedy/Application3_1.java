package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application3_1 {

    public static BufferedReader toBufferedReader(String str){
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        int maxCount = 0;

        BufferedReader br = toBufferedReader(input);
        int N = Integer.valueOf(br.readLine());              // 회의 수
        int[][] time = new int[N][2];                        // 회의 갯수 - 회의 시작시간, 종료시간

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.valueOf(st.nextToken());    // 시작시간
            time[i][1] = Integer.valueOf(st.nextToken());    // 종료시간
        }

        /* 설명
         *  그리디 알고리즘으로 접근하자면 하나의 회의실에서 가장 많은 회의를 열기 위해서는 종료시간 순으로 고민하는 것이 좋다.
         *  (빨리 끝나는 회의를 먼저 고려하는 것이 좋다.)
        * */
        Arrays.sort(time, (o1, o2) -> {

            /* 설명. 종료시간이 같은 회의에 대해서는 시작시간이 늦은 순(내림차순)으로 정렬 */
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];                        // 시작시간이 늦어야 회의시간이 짧기 때문에
            }

            /* 설명. 종료시간이 같지 않은 경우, 종료시간 이른 회의부터 정렬되도록(종료시간 오름차순) */
            return o1[1] - o2[1];
        });

        /* 설명. 앞선 회의가 끝나는 시간을 담아놓을 변수 선언 */
        int end =  0;

        /* 설명. time 배열에 담긴 회의들을 확인하며 앞선 회의의 종료 다음 회의가 진행되는지를 판별해 가능한 회의 추출 */
        for (int i = 0; i < N; i++) {
            /* 설명. 앞선 회의가  끝나는 시간과 일치하거나 이후에 시작하는 회의인가 */
            if(end <= time[i][0]){

                /* 종료시간으로 end 갱신 */
                end = time[i][1];
                maxCount++;
            }
        }
        return maxCount;
    }

}

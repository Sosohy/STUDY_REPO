package com.ohgiraffers.chap04.section01.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Application2 {

    public static BufferedReader toBufferedReader(String str){
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.valueOf(st.nextToken());         // 동전 갯수
        int K = Integer.valueOf(st.nextToken());         // 계산할 금액(가치의 합)

        int coin[] = new int[N];                         // 동전의 종류들을 담을 배열
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.valueOf(br.readLine());
        }
        int count = 0;

        for (int i = coin.length-1; i >= 0; i--) {
            if(coin[i] <= K){
                count += K / coin[i];

                /* coin[i]번째로 처리 후 남는 나머지 금액 */
                K = K % coin[i];
            }
            if(K == 0) return count;
        }
        return count;
    }
}

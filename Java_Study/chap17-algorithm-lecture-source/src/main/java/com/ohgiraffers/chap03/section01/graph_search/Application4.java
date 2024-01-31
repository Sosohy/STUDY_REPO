package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 수업목표. BFS와 DFS를 활용해 동일한 결과가나오는 것을 이애할 수 있다. */
public class Application4 {

    public static BufferedReader toBufferedReader(String str){
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    static boolean[] visit;

    static int[][] arr;

    static int node, line, start;

    static Queue<Integer> q = new LinkedList<>();

    static StringBuilder sb = new StringBuilder();


    public static String solution(String input) throws IOException {
        
        /* 설명. 테스트 코드로 2번째부터 테스트 케리스 문자열 넘어오면 앞에 누적된 것을 지워주고 시작하기 위한 코드 */
        sb.delete(0, sb.length());

        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.valueOf(st.nextToken());
        line = Integer.valueOf(st.nextToken());
        start = Integer.valueOf(st.nextToken());
        arr = new int[node + 1][node + 1];
        visit = new boolean[node+1];

        for (int i = 0; i < line; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int a = Integer.valueOf(st2.nextToken());
            int b = Integer.valueOf(st2.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(start);
        sb.append("\n");

        /* dfs할 때 visit 배열을 활용하기 때문에 아래 bfs를 위해 다시 false로 채워진 boolean[]으로 초기화 */
        visit = new boolean[node + 1];

        bfs(start);

        /* StringBuilder -> String */
        return sb.toString();
    }
    private static void dfs(int start) {
        visit[start] = true;
        sb.append(start + " ");

        /* node 번호와 인덱스가 동일한 체계이기 때문에 i는 node 번호까지 포함하게 반복되어야 한다. */
        for (int i = 0; i <= node; i++) {
            if(arr[start][i] == 1 && !visit[i])
                dfs(i);
        }
    }

    private static void bfs(int start) {
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start + " ");

            /* node 번호와 인덱스가 동일한 체계이기 때문에 i는 node 번호까지 포함하게 반복되어야 한다. */
            for (int i = 0; i <= node ; i++) {
                if(arr[start][i] == 1 && !visit[i]){
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }

}

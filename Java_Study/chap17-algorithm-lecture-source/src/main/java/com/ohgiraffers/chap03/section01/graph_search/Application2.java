package com.ohgiraffers.chap03.section01.graph_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 수업목표. BFS와 x, y좌표를 활용한 문제를 해결할 수 있다.(배열의 인덱스와 반대 개념) */
/* 필기
 *  너비우선탐색(Breadth-First Search)
 *  선입선출구조에 queue를 활용한다.
 *  시작노드에서 출발해 시작노드를 기준으로
 *  가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다.
* */
public class Application2 {

    /* 설명. 테스트 코드에서 입력 받는 방식을 문제에서 요구하는 대로 작성하고 문자열로 입력 받기 위해 변경된 코드 */
    public static BufferedReader toBufferedReader(String str){
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    static Queue<Node> q = new LinkedList<>();

    /* 상하좌우 개념의 좌표 배열 */
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};

    /* 배추밭 */
    static int map[][];

    /* 방문한 배추 좌표 배열 */
    static boolean visit[][];

    /* 현재 위치에 대한 좌표 */
    static int curX, curY;

    /* 심어진 배추의 갯수 */
    static int N, M, K;

    /* 필요한 배추흰지렁이 수 */
    public static int count = 0;

    /* 설명. x좌표와 y좌표를 인지하는 static 내부 클래스 */
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.valueOf(st.nextToken());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());

            /* 설명. 입력 받은 x, y 좌표와 배열을 만들 때 순서(행, 열)는 반대 개념 */
            map[y][x] = 1;
        }

        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    count++;
                    bfs(j, i);           // BFS의 인자는 x, y 좌표 순으로 받을 것이므로 i, j 확인하고 넘기기
                }
            }
        }
        return count;
    }

    /* 상하좌우에 배추가 심어져있으면 한번씩 동작 */
    private static void bfs(int x, int y) {
        q.offer(new Node(x, y));
        visit[y][x] = true;

        /* 설명. 연속적으로 상하좌우에 배추가 심어져 있다면 반복된다. */
        while(!q.isEmpty()){
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                curX = node.x + dirX[i];
                curY = node.y + dirY[i];

                /* 지금 보는 방향이 좌표로써 존재하면서 방문한 적이 없고 배추가 심어져 있다면 */
                if(rangeCheck() && visit[curY][curX] == false && map[curY][curX] == 1){
                    q.offer(new Node(curX, curY));
                    visit[curY][curX] = true;
                }
            }
        }
    }

    private static boolean rangeCheck() {
        return curX >= 0 && curX < M && curY >= 0 && curY < N;
    }

}

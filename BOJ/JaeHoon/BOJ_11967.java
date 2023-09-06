package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11967 {
    static boolean[][] isOn;
    static int N;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[][] on = new ArrayList[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                on[i][j] = new ArrayList<>();
            }
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            on[r1][c1].add(new int[]{r2,c2});
        }


        Queue<int[]> pq = new LinkedList<>();

        pq.offer(new int[]{1,1});
        int answer = 1;
        isOn = new boolean[N+1][N+1];
        isOn[1][1] = true;
        boolean[][] isVisited = new boolean[N+1][N+1];
        isVisited[1][1] = true;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            ArrayList<int[]> go = on[curr[0]][curr[1]];
            for (int[] room : go) {
                if(isOn[room[0]][room[1]]) continue;
                answer++;
                isOn[room[0]][room[1]] = true;
            }

            for(int i=0; i<4; i++) {
                int nextX = curr[0] + dx[i];
                int nextY = curr[1] + dy[i];

                if(nextX < 1 || nextY < 1 || nextX > N || nextY > N || isVisited[nextX][nextY]) continue;
                if(!isOn[nextX][nextY]) continue;
                isVisited[nextX][nextY] = true;
                pq.offer(new int[]{nextX,nextY});
            }

            for (int[] room : go) {
                if(isVisited[room[0]][room[1]]) continue;
                boolean cango = false;
                for(int i=0; i<4; i++) {
                    int nextX = room[0] + dx[i];
                    int nextY = room[1] + dy[i];

                    if(nextX < 1 || nextY < 1 || nextX > N || nextY > N) continue;
                    if(isVisited[nextX][nextY]) {
                        cango = true;
                        break;
                    }
                }
                if(cango) {
                    isVisited[room[0]][room[1]] = true;
                    pq.offer(new int[]{room[0],room[1]});
                }
            }
        }


        System.out.println(answer);
    }
}

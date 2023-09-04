package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14466 {
    static int N,K,R;
    static int[][] map;
    static boolean[][] isVisited;
    static boolean[][][][] road;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        isVisited = new boolean[N+1][N+1];
        road = new boolean[N+1][N+1][N+1][N+1];

        for(int i=1; i<=R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            road[r1][c1][r2][c2] = true;
            road[r2][c2][r1][c1] = true;
        }

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        long answer = 0;
        for(int i=1; i<=K-1; i++) {
            for(int j=i+1; j<=K; j++) {
                answer++;
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(map[i][j] == 1 && !isVisited[i][j]) {
                    int cow = bfs(i,j);
//                    System.out.println("i = " + i + " j = " + j + " cow = " + cow);
                    int sum = 0;
                    for(int r=1; r<=cow-1; r++) {
                        for(int c=r+1; c<=cow; c++) {
                            sum++;
                        }
                    }
//                    System.out.print(" sum = " + sum);
                    answer -= sum;
                }
            }
        }


        System.out.println(answer);
    }
    public static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        isVisited[r][c] = true;
        int cowCnt = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for(int i=0; i<4; i++) {
                int nextX = curr[0] + dx[i];
                int nextY = curr[1] + dy[i];

                if(nextX < 1 || nextX > N || nextY < 1 || nextY > N || isVisited[nextX][nextY]) continue;
                if(road[curr[0]][curr[1]][nextX][nextY]) continue;
                if(map[nextX][nextY] == 1) cowCnt++;
                q.offer(new int[]{nextX,nextY});
                isVisited[nextX][nextY] = true;
            }
        }

        return cowCnt;
    }
}

package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836 {
    static int N,M,T;
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        int result = Math.min(visited[N-1][M-1][1], visited[N-1][M-1][0]);
        System.out.println(result == Integer.MAX_VALUE ? "Fail" : result <= T ? result : "Fail");
    }

    public static void bfs() {
        visited = new int[N][M][2];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        Queue<Soldier> q = new LinkedList<>();
        q.offer(new Soldier(0,0, 0,false));
        visited[0][0][0] = 0;

        while (!q.isEmpty()) {
            Soldier soldier = q.poll();

            for(int i=0; i<4; i++) {
                int nx = soldier.x + dx[i];
                int ny = soldier.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(!soldier.isHasSword && map[nx][ny] == 1) continue;

                if(soldier.isHasSword) {
                    if(visited[nx][ny][1] <= soldier.cnt + 1) continue;
                    visited[nx][ny][1] = soldier.cnt + 1;
                }else {
                    if(visited[nx][ny][0] <= soldier.cnt + 1) continue;
                    visited[nx][ny][0] = soldier.cnt + 1;
                }


                boolean isHasSword = soldier.isHasSword || map[nx][ny] == 2;
                q.offer(new Soldier(nx, ny, soldier.cnt + 1, isHasSword));
            }
        }
    }
    static class Soldier {
        int x,y,cnt;
        boolean isHasSword;

        public Soldier(int x, int y, int cnt, boolean isHasSword) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isHasSword = isHasSword;
        }
    }
}
//6 6 1
//0 0 0 0 1 1
//0 0 0 0 0 2
//1 1 1 0 1 0
//0 0 0 0 0 0
//0 1 1 1 1 1
//0 0 0 0 0 0
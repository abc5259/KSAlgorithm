package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
    static int M,N,H;
    static int[][][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];

        Queue<int[]> q = new ArrayDeque<>();
        boolean check = true;
        for(int h=0; h<H; h++) {
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                    if(map[h][i][j] == 0) check = false;
                    if(map[h][i][j] == 1) q.offer(new int[]{h,i,j});
                }
            }
        }
        if(check) {
            System.out.println(0);
            return;
        }
        int result = bfs(q);
        System.out.println(result == -1 ? -1 : result-1);
    }

    public static int bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for(int i=0; i<4; i++) {
                int nx = curr[1] + dx[i];
                int ny = curr[2] + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[curr[0]][nx][ny] != 0) continue;
                map[curr[0]][nx][ny] = map[curr[0]][curr[1]][curr[2]] + 1;
                q.offer(new int[]{curr[0],nx,ny});
            }

            // 위칸
            int nh = curr[0] + 1;
            if(nh < H && map[nh][curr[1]][curr[2]] == 0) {
                map[nh][curr[1]][curr[2]] = map[curr[0]][curr[1]][curr[2]] + 1;
                q.offer(new int[]{nh,curr[1],curr[2]});
            }

            // 아래
            nh = curr[0] - 1;
            if(nh >= 0 && map[nh][curr[1]][curr[2]] == 0) {
                map[nh][curr[1]][curr[2]] = map[curr[0]][curr[1]][curr[2]] + 1;
                q.offer(new int[]{nh,curr[1],curr[2]});
            }
        }

        int max = Integer.MIN_VALUE;
        for(int h=0; h<H; h++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[h][i][j] == -1) continue;
                    if(map[h][i][j] == 0) return -1;
                    max = Math.max(max, map[h][i][j]);
                }
            }
        }
        return max;
    }
}

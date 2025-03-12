package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503 {
    static int N,M;
    static int[] dx = {-1,0,1,0}; // 북 동 남 서
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(map[r][c] == 0) {
            map[r][c] = -1;
            System.out.println(dfs(new int[]{r, c, d}, 0) + 1);
            return;
        }
        System.out.println(dfs(new int[]{r, c, d}, 0));
    }

    static int dfs(int[] cur, int total) {
        boolean isCleanAll = true;
        for(int i=0; i<4; i++) {
            int nx = cur[0] + dx[i];
            int ny = cur[1] + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1) {
                continue;
            }
            if(map[nx][ny] == 0) {
                isCleanAll = false;
                break;
            }
        }

        if(isCleanAll) {
            int backD = (cur[2] + 2) % 4;
            int nx = cur[0] + dx[backD];
            int ny = cur[1] + dy[backD];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1) {
                return total;
            }
            if(map[nx][ny] == 0) {
                map[nx][ny] = -1;
                return dfs(new int[]{nx,ny,cur[2]}, total+1);
            }
            return dfs(new int[]{nx,ny,cur[2]}, total);
        }

        int nd = (cur[2] - 1) < 0 ? 3 : cur[2] - 1;
        int nx = cur[0] + dx[nd];
        int ny = cur[1] + dy[nd];
        if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1) {
            return dfs(new int[]{cur[0],cur[1],nd}, total);
        }
        if(map[nx][ny] == 0) {
            map[nx][ny] = -1;
            return dfs(new int[]{nx,ny,nd}, total+1);
        }
        return dfs(new int[]{cur[0],cur[1],nd}, total);
    }
}

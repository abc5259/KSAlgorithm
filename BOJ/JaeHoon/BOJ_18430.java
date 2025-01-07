package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18430 {
    static int N,M;
    static int[][] map;
    static int[][][] shapes = {
            {{0,0}, {0,1}, {1,1}},
            {{0,0}, {1,0}, {1,-1}},
            {{0,0}, {1,0}, {1,1}},
            {{0,0}, {0,1}, {1,0}}
    };
    static int[][] cal = {
            {1,2,1},
            {1,2,1},
            {1,2,1},
            {2,1,1}
    };
    static boolean[][] isUsed;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isUsed = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0,0,0);
        System.out.println(max);
    }

    public static void solve(int x, int y, int sum) {
        if(x == N) {
            max = Math.max(max, sum);
            return;
        }

        if(y == M) {
            solve(x+1, 0, sum);
            return;
        }

        solve(x, y+1, sum);
        for(int i=0; i<4; i++) {
            int total = calculate(x, y, shapes[i], cal[i]);
            if(total == -1) continue;
            solve(x, y+1, sum + total);
            for (int[] arr : shapes[i]) {
                int nx = x + arr[0];
                int ny = y + arr[1];
                isUsed[nx][ny] = false;
            }
        }
    }

    private static int calculate(int x, int y, int[][] shape, int[] call) {
        int total = 0;
        for (int i=0; i<3; i++) {
            int nx = x + shape[i][0];
            int ny = y + shape[i][1];
            if(nx >= N || ny >= M || nx < 0 || ny < 0 || isUsed[nx][ny]) {
                return -1;
            }
            total += map[nx][ny] * call[i];
        }

        for (int[] arr : shape) {
            int nx = x + arr[0];
            int ny = y + arr[1];
            isUsed[nx][ny] = true;
        }

        return total;
    }
}

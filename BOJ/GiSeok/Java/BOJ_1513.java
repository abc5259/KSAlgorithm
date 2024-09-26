/**
 * 1513 - 경로 찾기 [성공(반례힌트)|02:20:09]
 * 골드2, DP/DFS, 시도4
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1513 {

    static int[] dy = {1, 0};
    static int[] dx = {0, 1};

    static int n, m, c;
    static int[][] map;
    static int[][][][] dp;

    static int go(int y, int x, int c, int prev) {

        if (c < 0) return 0;
        if (dp[y][x][c][prev] != -1) return dp[y][x][c][prev];
        if (y == n && x == m) {
            if (c == 0 && map[y][x] == 0) return 1;
            if (c == 1 && map[y][x] > prev) return 1;
            return 0;
        }

        dp[y][x][c][prev] = 0;
        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 1 || nx < 1 || ny > n || nx > m) continue;

            if (map[y][x] == 0) dp[y][x][c][prev] = (dp[y][x][c][prev] + go(ny, nx, c, prev)) % 1000007;
            else if (prev < map[y][x]) dp[y][x][c][prev] = (dp[y][x][c][prev] + go(ny, nx, c-1, map[y][x])) % 1000007;
        }

        return dp[y][x][c][prev];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = i+1;
        }

        dp = new int[n+1][m+1][c+1][c+1];
        for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= m; b++)
                for (int d = 0; d <= c; d++) Arrays.fill(dp[a][b][d], -1);
        }

        for (int i = 0; i <= c; i++)
            System.out.print(go(1, 1, i, 0) + " ");
        System.out.println();
    }
}

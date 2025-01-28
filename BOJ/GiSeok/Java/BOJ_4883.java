/**
 * [S1 DP] 삼각 그래프 - O, 01:12:07
 * 시도 7
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int k = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            long[][] map = new long[n][3];
            long[][] dp = new long[n][3];

            for (int y = 0; y < n; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < 3; x++) map[y][x] = Long.parseLong(st.nextToken());
            }

            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = map[0][1];
            dp[0][2] = map[0][1] + map[0][2];
            for (int y = 1; y < n; y++) {
                dp[y][0] = Math.min(dp[y-1][0] + map[y][0], dp[y-1][1] + map[y][0]);
                dp[y][1] = Math.min(dp[y-1][0] + map[y][1], dp[y-1][1] + map[y][1]);
                dp[y][1] = Math.min(dp[y][1], dp[y-1][2] + map[y][1]);
                dp[y][1] = Math.min(dp[y][1], dp[y][0] + map[y][1]);
                dp[y][2] = Math.min(dp[y-1][1] + map[y][2], dp[y-1][2] + map[y][2]);
                dp[y][2] = Math.min(dp[y][2], dp[y][1] + map[y][2]);
            }

            System.out.println((k++) + ". " + dp[n-1][1]);
        }
    }
}

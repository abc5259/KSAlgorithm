/**
 * 1149 - RGB거리 [성공|00:18:20]
 * 실버1, DP, 시도1
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1149 {
    // 시간제한 0.5초, 메모리제한 128MB
    static int[][] houses;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        houses = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) houses[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][3];
        for (int i = 0; i < n; i++) { for (int j = 0; j < 3; j++) dp[i][j] = Integer.MAX_VALUE; }
        dp[0][0] = houses[0][0];
        dp[0][1] = houses[0][1];
        dp[0][2] = houses[0][2];
        for (int i = 1; i < n; i++) {
            for (int rgb = 0; rgb < 3; rgb++) {
                for (int c = 0; c < 3; c++) {
                    if (c == rgb) continue;

                    dp[i][c] = Math.min(dp[i-1][rgb] + houses[i][c], dp[i][c]);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++)
            ret = Math.min(dp[n-1][j], ret);

        System.out.println(ret);
    }
}

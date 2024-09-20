/**
 * 4811 - 알약 [성공(반례힌트)|01:29:32]
 * 골드5, DP, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4811 {

    static int n;
    static long[][] dp;

    static long go(int w, int h) {

        if (h == n && w == n) return 1;
        if (dp[h][w] != 0) return dp[h][w];

        if (w+1 <= n)
            dp[h][w] = go(w+1, h);
        if (h+1 <= n && h != w)
            dp[h][w] += go(w, h+1);
        return dp[h][w];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 1000; i++) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            dp = new long[n+1][n+1];
            System.out.println(go(0, 0));
        }
    }
}

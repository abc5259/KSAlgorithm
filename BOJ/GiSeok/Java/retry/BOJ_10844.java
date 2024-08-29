/**
 * 10844 - 쉬운 계단 수 [성공(반례힌트)|01:14:18]
 * 실버1, DP, 시도5
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_10844 {
    // 시간제한 1초, 메모리제한 256MB
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][10];
        for (int i = 0; i < 10; i++) dp[0][i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i-1][j+1];
                else if (j == 9) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        int ret = 0;
        for (int i = 1; i < 10; i++) ret = (ret + dp[n - 1][i]) % 1000000000;

        System.out.println(ret);
    }
}

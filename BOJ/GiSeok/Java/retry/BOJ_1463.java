/**
 * 1463 - 1로 만들기 [성공|00:37:07]
 * 실버3, DP, 시도3
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_1463 {
    // 시간제한 0.15초, 메모리제한 128MB
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[1000001];

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);

            dp[i] = Math.min(dp[i], dp[i-1] + 1);
        }

        System.out.println(dp[n]);
    }
}

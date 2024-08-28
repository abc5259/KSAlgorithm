/**
 * 1904 - 01타일 [성공|00:05:28]
 * 실버3, DP, 시도1
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_1904 {
    // 시간제한 0.75초, 메모리제한 256MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) dp[i] = (dp[i-1] + dp[i-2]) % 15746;

        System.out.println(dp[n]);
    }
}

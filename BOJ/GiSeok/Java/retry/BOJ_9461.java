/**
 * 9461 - 파도반 수열 [성공|00:18:28]
 * 실버3, DP, 시도5
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_9461 {
    // 시간제한 1초, 메모리제한 128MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[0] = 0;
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for (int i = 6; i <= 100; i++) dp[i] = dp[i-1] + dp[i-5];

        for (int T = 0; T < t; T++)
            System.out.println(dp[Integer.parseInt(br.readLine())]);
    }
}

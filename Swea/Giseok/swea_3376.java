/**
 * 3376. 파도반 수열(D3|DP) [O|00:08:30]
 * 시도2
 */
package Swea.Giseok;

import java.io.*;

public class swea_3376 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[101];
        dp[0] = 0; dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2;
        for (int i = 5; i <= 100; i++) dp[i] = dp[i-1] + dp[i-5];

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println("#" + tc + " " + dp[n]);
        }
    }
}

/**
 * [S2 DP] 1, 2, 3 더하기 3 - O, 00:10:29
 * 시도 2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[1000001];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i <= 1000000; i++) dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n]);
        }
    }
}

/**
 * 1 = 1 -> 1개
 * 2 = 1+1, 2 -> 2개
 * 3 = 1+1+1, 1+2, 2+1, 3 -> 4개
 * 4 = 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1 -> 7개
 * 5 = 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 1+2+2, 2+1+2, 2+2+1, 1+1+3, 1+3+1, 3+1+1,
 *      2+3, 3+2 -> 13개
 * 6 = 1+1+1+1+1+1, 1+1+1+1+2, 1+1+1+2+1, 1+1+2+1+1, 1+2+1+1+1, 2+1+1+1+1,
 *      1+1+2+2, 1+2+1+2, 2+1+1+2, 1+2+2+1, 2+2+1+1, 2+1+2+1, 2+2+2,
 *      1+1+1+3, 1+1+3+1, 1+3+1+1, 3+1+1+1, 1+2+3, 2+1+3, 1+3+2, 2+3+1, 3+1+2, 3+2+1,
 *      3+3 -> 24개
 *
 * dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
 */

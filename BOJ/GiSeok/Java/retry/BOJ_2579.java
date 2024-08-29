/**
 * 2579 - 계단 오르기 [성공|00:32:23]
 * 실버3, DP, 시도1
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;

public class BOJ_2579 {
    // 시간제한 1초, 메모리제한 128MB
    // 계단 갯수가 300 이하이므로 한 개의 계단을 밟을까 말까? = 2^300 완탐x
    // 그럼 DP?
    static int[] stairs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        stairs = new int[n+1];
        for (int i = 1; i <= n; i++) stairs[i] = Integer.parseInt(br.readLine());

        dp = new int[n+1][2];
        dp[1][0] = stairs[1];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-2][0] + stairs[i], dp[i-2][1] + stairs[i]);
            dp[i][1] = dp[i-1][0] + stairs[i];
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}

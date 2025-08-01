package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[117];

        dp[1] = dp[2] = dp[3] = 1;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        System.out.print(dp[n]);
    }
}

// S4 피보나치 비스무리한 수열 DP
// 걍 쉬웠음
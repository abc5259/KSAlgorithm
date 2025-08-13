package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1788 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n > 0) {
            System.out.println(1);
        } else if (n < 0) {
            n = Math.abs(n);
            if (n % 2 == 0) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
        } else {
            System.out.println(0);
        }
        int[] dp = new int[1_000_001];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        System.out.println(dp[n]);
    }
}
// S3 피보나치 수의 확장 DP
// 바텀업으로 그냥 풀었다.
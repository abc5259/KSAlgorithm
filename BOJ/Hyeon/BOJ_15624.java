package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15624 {
    private final static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[1_000_001];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        System.out.print(dp[n]);
    }
}
// S4 피보나치 수 7 DP
// 쉽게 풀었다 일단 n의 최대까지의 범위로 배열을 만들되 n 까지 해서
// 반복문으로 바텀업 방식을 쓰면되는거 같다..

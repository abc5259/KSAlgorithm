package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2748_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;


        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
// B1 피보나치 수 2 DP
// 이건 bottom up 방식으로 아래부터 위로 접근
// 재귀는 탑다운 방식으로 쪼개서 내려가는 방식
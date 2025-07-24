package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[36];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < 36; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }
        System.out.print(dp[n]);
    }
}
// S4 점화식 DP
// 그냥 기본적인 문제 출제한 그대로 풀면된다.

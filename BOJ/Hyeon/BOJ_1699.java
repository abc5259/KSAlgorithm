package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - j * j] + 1) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }
        System.out.print(dp[N]);
    }
}

// S2 제곱수의 합 DP
// 반례
// 41 이 존재한다. 36 + 4 + 1 을 생각했는데 25 + 16이 되긴하다.
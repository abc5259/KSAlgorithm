package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {
    final static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i]) % MOD;
        }
        System.out.println(sum);
    }
}
// S1 쉬운 계단 수 DP
// 일단 자릿수 개념을 이해해야되고 앞자리에 오는 수가 0이 될 수 도 있다. 그치만 0이 오게되면
// 이전의 자리수 1이 가진 가짓수만 가져올 수 있다.
// 9 또한 8로 시작하는 이전의 자릿수의 갯수만 가지고 올 수 있고
// 나머지는 이전 자릿수의 -1과 +1 2개의 값을 합산한 결과를 가질 수 있다.
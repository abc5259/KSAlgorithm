package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][1] = 1;
        }
        for (int i = 0; i <= k; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        System.out.println(dp[n][k]);
    }
}

// G5 합분해 DP
// 이거 점화식 구하기 위해서 바텀 업 방식으로 경우의 수 나눠서 계산해봐야 한다.
// k와 n의 경우를 대입해서 비교하기위해 2차원 배열 로 그리드 형태로 해서 값을 연산할 때 규칙을 찾아야한다.
package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15990 {
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[100_001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < 100_001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long sum = (dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
// S1 1,2,3 더하기 5 DP
// 일단 2차원 배열을 통해서 점화식을 구해나갔다 정수 1,2,3 까지는 입력값으로 관리하고
// 최대범위인 100000을 고려해서 배열을 만든다음 1,2,3일때를 관리할 수 있는 [4] 배열을 만들고
// 표 형태로 봐서 MOD 연산을 위한 점화식을 구했다
// refactor

// 일단 T 만큼 반복해서 DP 값을 구해야 하는데
// 이는 반복문을 그냥 다 돌려버린다음 DP값만 합 연산 모듈러 연산해서 구하는게
// 시간적으로 훨씬 나았다.
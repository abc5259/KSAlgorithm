package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] pipe = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pipe[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][][] dp = new long[N][N][3];
        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (pipe[i][j] == 1)
                    continue;
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                if (i > 0) {
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                }
                if (i > 0 && pipe[i - 1][j] == 0 & pipe[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }
        long res = 0;
        for (int i = 0; i < 3; i++) {
            res += dp[N - 1][N - 1][i];
        }
        System.out.println(res);
    }
}

// G4 파이프 옮기기 2 DP
// 같은 풀이 방식으로 3차원으로 구성하여서 풀었다.
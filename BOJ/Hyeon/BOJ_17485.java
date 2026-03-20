package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17485 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] fuel = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                fuel[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], 1_000_000);
            }
        }

        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = fuel[0][j];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j > 0) {
                    dp[i][j][0] = fuel[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                }
                dp[i][j][1] = fuel[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                if (j + 1 < M) {
                    dp[i][j][2] = fuel[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
                }
            }
        }

        int min = 1_000_000;

        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                min = Math.min(min, dp[N - 1][j][d]);
            }
        }
        System.out.println(min);
    }
}
// G5 진우의 달 여행 (Large) DP 다시
// 50분
// 아니 풀이 제대로 다 풀어놨는데 min 값 때문에 다 날림.
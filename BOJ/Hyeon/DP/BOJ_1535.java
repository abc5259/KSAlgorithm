package BOJ.Hyeon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int K = 100;
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] L = new int[N + 1];
        int[] J = new int[N + 1];

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
            J[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int p = 1; p <= K; p++) {
                if (L[i] >= p) {
                    dp[i][p] = dp[i - 1][p];
                } else {
                    dp[i][p] = Math.max(dp[i - 1][p], dp[i - 1][p - L[i]] + J[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}

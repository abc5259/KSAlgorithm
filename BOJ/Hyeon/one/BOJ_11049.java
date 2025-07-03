package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] node = new int[N + 1][2];
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            node[i][0] = Integer.parseInt(st.nextToken());
            node[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 2; i <= N; i++) {
            for (int start = 1; start <= N - i + 1; start++) {
                int end = start + i - 1;
                dp[start][end] = Integer.MAX_VALUE;

                for (int k = start; k < end; k++) {
                    int cost = dp[start][k] + dp[k + 1][end] + node[start][0] * node[k][1] * node[end][1];
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }
        System.out.println(dp[1][N]);
    }
}

// G3 행렬 곱셈 순서 DP
// 어렵다 너무 오래 투자했음 다시 풀어봐야될듯
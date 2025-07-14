package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] candy = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                candy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = candy[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 1 < N) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + candy[i + 1][j]);
                }
                if (j + 1 < M) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + candy[i][j + 1]);
                }
                if (i + 1 < N && j + 1 < M) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + candy[i + 1][j + 1]);
                }
            }
        }
        System.out.println(dp[N - 1][M - 1]);
    }
}

// S2 이동하기 DP
// 일단 풀었다 3갈래의 길에서 최대의 값을 구하기에 i와 J에 대한 범위만 조절해주고
// 시작 초기값만 일치하게 해주면 크게 어려운 문제가 아니었다.
package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[N + 1];
        int[][] dp = new int[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= N - i + 1; j++) {
                if (arr[j] == arr[j + i - 1] && dp[j + 1][j + i - 2] == 1) {
                    dp[j][j + i - 1] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E]).append("\n");
        }
        System.out.print(sb);
    }
}

// G4 팰린드롬? DP
// 일단 풀었다.
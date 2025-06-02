package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] p = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], p[j] + dp[i - j]);
            }
        }
        System.out.println(dp[N]);
    }
}

// S1 카드 구매하기 DP
// 일단 풀었다 다시 풀어보자
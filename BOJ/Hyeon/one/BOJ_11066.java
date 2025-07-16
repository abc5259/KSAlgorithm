package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] dp;
        int[] arr;
        int[] sum;
        int N;
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N + 1][N + 1];
            arr = new int[N + 1];
            sum = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = arr[i] + sum[i - 1];
            }

            for (int len = 2; len <= N; len++) {
                for (int l = 1; l + len - 1 <= N; l++) {
                    int r = l + len - 1;
                    dp[l][r] = Integer.MAX_VALUE;

                    for (int k = l; k < r; k++) {
                        int cost = dp[l][k] + dp[k + 1][r] + sum[r] - sum[l - 1];
                        dp[l][r] = Math.min(dp[l][r], cost);
                    }
                }
            }
            System.out.println(dp[1][N]);
        }
    }
}

// G3 파일 합치기 DP
// 일단 풀었는데 다시 풀어봐야 한다. 틀렸다.
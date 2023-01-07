package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] w = new int[N + 1];
        int[] v = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++)
            w[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++)
            v[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][10001];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < N + 1; i++) {
            for (int cost = 1; cost < 10001; cost++) {
                if (v[i] > cost)
                    dp[i][cost] = dp[i-1][cost];
                else
                    dp[i][cost] = Math.max(dp[i-1][cost], dp[i-1][cost-v[i]] + w[i]);

                if (dp[i][cost] >= M)
                    min = Math.min(min, cost);
            }
        }

        System.out.println(min);
    }
}
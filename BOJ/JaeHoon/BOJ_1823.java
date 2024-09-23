package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1823 {
    static int[][] dp;
    static boolean[] isVisited;
    static int[] v;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        v = new int[N+1];
        isVisited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            v[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N+2][N+2];
        for(int i=1; i<=N; i++) {
            dp[i][i] = v[i] * N;
        }

        int dfs = dfs(1, 1, N);

        System.out.println(dfs);
    }

    static int dfs(int k, int l, int r) {
        if(dp[l][r] > 0) {
            return dp[l][r];
        }

        dp[l][r] = Math.max(dfs(k+1,l+1, r) + v[l]*k, dfs(k+1, l, r-1)+ v[r]*k);

        return dp[l][r];
    }
}

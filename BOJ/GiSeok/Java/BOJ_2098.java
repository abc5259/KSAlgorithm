/**
 * 2098 - 외판원 순회 [실패]
 * 골드1, DP/비트마스킹, 시도5
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2098 {

    static int n;
    static int[][] w;
    static int[][] dp;
    static int inf = 17000001;

    static int tsp(int here, int visited) {
        if (visited == (1 << n) - 1) return (w[here][0] != 0) ? w[here][0] : inf;
        if (dp[here][visited] != 0) return dp[here][visited];

        dp[here][visited] = inf;
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) != 0) continue;
            if (w[here][i] == 0) continue;
            int cost = tsp(i, visited | (1 << i)) + w[here][i];
            dp[here][visited] = Math.min(cost, dp[here][visited]);
        }

        return dp[here][visited];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                w[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][(1 << n) - 1];
        System.out.println(tsp(0, 1));
    }
}

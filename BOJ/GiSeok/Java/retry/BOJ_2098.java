package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.*;

public class BOJ_2098 {

    static int[][] dp;
    static int[][] w;
    static int n;

    static int inf = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][(1 << n) - 1];
        // 1 10 100 1000 1 0000 1111 = 12 0 ~ 11 1111
        System.out.println(tsp(0, 1));
    }

    private static int tsp(int now, int visited) {
        if (visited == (1 << n) - 1) return w[now][0] == 0 ? inf : w[now][0];

        if (dp[now][visited] != 0) return dp[now][visited];

        dp[now][visited] = inf;
        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) != 0) continue;
            if (w[now][next] == 0) continue;

            dp[now][visited] = Math.min(
                dp[now][visited],
                tsp(next, visited | (1 << next)) + w[now][next]
            );
        }

        return dp[now][visited];
    }
}

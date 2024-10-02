/**
 * 1480 - 보석 모으기(G1) [X]
 * DP, 시도5
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_1480 {

    static int n, m, c;
    static int[] jewel;
    static int[][][] dp;

    static int go(int bag, int w, int visited) {
        if (bag == m) return 0;
        if (dp[bag][visited][w] != 0) return dp[bag][visited][w];

        dp[bag][visited][w] = Math.max(dp[bag][visited][w], go(bag+1, c, visited));
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) == 0 && 0 <= w - jewel[i]) {
                dp[bag][visited][w] = Math.max(go(bag, w - jewel[i], visited | (1 << i)) + 1, dp[bag][visited][w]);
            }
        }

        return dp[bag][visited][w];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        jewel = new int[n];
        for (int i = 0; i < n; i++) jewel[i] = Integer.parseInt(st.nextToken());

        dp = new int[m][1 << 14][c+1];
        System.out.println(go(0, c, 0));
    }
}
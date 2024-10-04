/**
 * 5215. 햄버거 다이어트(D3/DP) [O|00:12:33]
 * 시도4
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_5215_2 {
    static int[][] dp;
    static int[] cal;
    static int[] point;
    static int p, k;

    static int go(int idx, int kcal) {

        if (kcal > k) return -987654321;
        if (idx == p) return 0;
        if (dp[idx][kcal] != -1) return dp[idx][kcal];

        dp[idx][kcal] = go(idx + 1, kcal + cal[idx]) + point[idx];
        dp[idx][kcal] = Math.max(dp[idx][kcal], go(idx + 1, kcal));

        return dp[idx][kcal];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            point = new int[p];
            cal = new int[k];
            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                point[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[p][k+1];
            for (int i = 0; i < p; i++) Arrays.fill(dp[i], -1);

            System.out.println("#" + tc + " " + go(0, 0));
        }
    }
}

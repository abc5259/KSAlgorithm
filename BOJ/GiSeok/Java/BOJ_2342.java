/**
 * 2342 - G3 Dance Dance Revolution [X]
 * DP, 시도12
 */
package BOJ.GiSeok.Java;

import java.util.*;
import java.io.*;

public class BOJ_2342 {

    static int[] a;
    static int[][][] dp;

    static int check(int from, int to) {

        if (from == 0) return 2;
        if (from == to) return 1;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }

    static int go(int idx, int left, int right) {
        if (a[idx] == 0) return 0;
        if (dp[left][right][idx] != -1) return dp[left][right][idx];

        dp[left][right][idx] = go(idx + 1, a[idx], right) + check(left, a[idx]);
        dp[left][right][idx] = Math.min(go(idx + 1, left, a[idx]) + check(right, a[idx]), dp[left][right][idx]);

        return dp[left][right][idx];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = new int[100001];
        for (int i = 0; st.hasMoreTokens(); i++)
            a[i] = Integer.parseInt(st.nextToken());

        dp = new int[5][5][100001];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) Arrays.fill(dp[i][j], -1);
        }

        System.out.println(go(0, 0, 0));
    }
}
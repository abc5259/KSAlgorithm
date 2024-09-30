/**
 * 1509 - 팰린드롬 분할 [실패|01:38:39]
 * 골드1, DP, 시도3
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.Arrays;

public class BOJ_1509 {

    static String str;
    static int[][] dp;
    static int[] dp2;

    static int go(int here) {
        if (here == str.length()) return 0;
        if (dp2[here] != 987654321) return dp2[here];

        for (int i = 1; here + i <= str.length(); i++)
            if (dp[here][i] == 1) dp2[here] = Math.min(dp2[here], go(here + i) + 1);

        return dp2[here];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        int n = str.length();
        dp = new int[n+1][n+1];

        for (int i = 0; i < n; i++) dp[i][1] = 1;
        for (int i = 0; i < n-1; i++) dp[i][2] = str.charAt(i) == str.charAt(i+1) ? 1 : 0;

        for (int size = 3; size <= n; size++) {
            for (int i = 0; i+size <= n; i++) {
                if (str.charAt(i) == str.charAt(i + size - 1) && dp[i + 1][size - 2] == 1) dp[i][size] = 1;
            }
        }

        dp2 = new int[n+1];
        Arrays.fill(dp2, 987654321);
        int ret = go(0);
        System.out.println(ret);
    }
}

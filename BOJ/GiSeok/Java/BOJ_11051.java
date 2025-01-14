/**
 * [S2 수학] 이항 계수 2 - O, 00:16:17
 * 시도 6
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_11051 {

    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n+1][k+1];
        System.out.println(bino(n, k) % 10007);

        // ver1
//        BigInteger[] dp = new BigInteger[n+1];
//        dp[0] = BigInteger.ONE;
//        for (int i = 1; i <= n; i++)
//            dp[i] = dp[i-1].multiply(new BigInteger(String.valueOf(i)));
//
//        System.out.println((dp[n].divide (dp[k].multiply(dp[n-k])).remainder(new BigInteger(String.valueOf(10007)))));
    }

    public static int bino(int n, int k) {
        if (k == 0 || n == k) return 1;
        if (dp[n][k] != 0) return dp[n][k];

        dp[n][k] = (bino(n-1, k-1) + bino(n-1, k)) % 10007;
        return dp[n][k];
    }
}

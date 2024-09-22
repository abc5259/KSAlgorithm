/**
 * 2293 - 동전 1 [실패|01:09:06]
 * 골드5, DP, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293 {

    static int[] coins;
    static int[] dp;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        dp = new int[k+1];

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            for (int j = coins[i]; j <= k; j++) {
                if (j - coins[i] < 0) continue;
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[k]);
    }
}

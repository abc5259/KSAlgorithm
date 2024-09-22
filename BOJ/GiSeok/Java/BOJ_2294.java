/**
 * 2294 - 동전 2 [성공|00:37:00]
 * 골드5, DP, 시도4
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294 {

    static int[] coins;
    static int[] dp;
    static int n, k;

    static int go(int coin) {

        if (coin > k) return 987654321;
        if (coin == k) return 0;
        if (dp[coin] != -1) return dp[coin];

        dp[coin] = 987654321;
        for (int i = 0; i < n; i++)
            dp[coin] = Math.min(go(coins[i] + coin) + 1, dp[coin]);

        return dp[coin];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());
        dp = new int[k+1];
        Arrays.fill(dp, -1);

        int ret = go(0);
        System.out.println(ret == 987654321 ? -1 : ret);
    }
}

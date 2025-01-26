/**
 * [S1 DP] 극장 좌석 - X
 * 00:49:22
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i-1] + dp[i-2];

        int ret = 1;
        int prev = 1;
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(br.readLine());

            ret *= dp[now - prev];
            prev = now + 1;
        }

        if (prev != (n+1)) ret *= dp[(n+1) - prev];
        System.out.println(ret);
    }
}

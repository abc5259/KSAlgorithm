/**
 * 12852 - 1로 만들기 2(Bottom-Up) [성공(반례힌트)|00:59:32]
 * 실버1, DP, 시도4
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12852 {
    // 시간제한 0.5초, 메모리제한 512MB

    static int[] dp;
    static int[] find;

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        find = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i % 3 == 0)
                if (dp[i] > dp[i/3] + 1) { dp[i] = dp[i/3] + 1; find[i] = i/3; }
            if (i % 2 == 0)
                if (dp[i] > dp[i / 2] + 1) { dp[i] = dp[i / 2] + 1; find[i] = i/2; }

            if (dp[i] > dp[i-1] + 1) {  dp[i] = dp[i-1] + 1; find[i] = i-1; }
        }

        System.out.println(dp[n]);
        int idx = n;
        while (idx != 0) {
            System.out.print(idx + " ");
            idx = find[idx];
        }
        System.out.println();
    }
}

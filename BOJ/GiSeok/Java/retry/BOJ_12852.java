/**
 * 12852 - 1로 만들기 2(Top-Down) [성공(반례힌트)|00:59:32]
 * 실버1, DP, 시도4
 */
package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_12852 {
    // 시간제한 0.5초, 메모리제한 512MB

    static int[] dp;
    static int[] find;

    static int go(int n) {

        if (n == 1) return 0;
        if (dp[n] != Integer.MAX_VALUE) return dp[n];

        int ret;
        if (n % 3 == 0) { dp[n] = go(n/3) + 1; find[n] = n/3; }
        if (n % 2 == 0) {
            ret = go(n / 2) + 1;
            if (dp[n] > ret) { dp[n] = ret; find[n] = n/2; }
        }

        ret = go(n-1) + 1;
        if (dp[n] > ret) { dp[n] = ret; find[n] = n-1; }

        return dp[n];
    }

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        find = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int ret = go(n);
        System.out.println(ret);

        int idx = n;
        while (idx != 0) {
            System.out.print(idx + " ");
            idx = find[idx];
        }
        System.out.println();
    }
}

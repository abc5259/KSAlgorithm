/**
 * [S3 DP] 피보나치 수의 확장 - O, 00:14:04
 * 시도 2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1788 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[1000001];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= 1000000; i++) dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_000;

        int n = Integer.parseInt(br.readLine());
        if (n > 0) {
            System.out.println(1);
        } else if (n < 0) {
            n = Math.abs(n);
            if (n % 2 == 0) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
        } else {
            System.out.println(0);
        }

        System.out.println(dp[n]);
    }
}

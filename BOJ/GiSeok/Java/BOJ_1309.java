package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9001;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9001;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9001;
        }

        long ans = (dp[n][0] + dp[n][1] + dp[n][2]) % 9001;
        System.out.println(ans);
    }
}

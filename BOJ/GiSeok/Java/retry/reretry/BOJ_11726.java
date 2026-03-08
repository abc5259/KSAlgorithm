package BOJ.GiSeok.Java.retry.reretry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[1][0] = 1;
        dp[1][1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 10007;
            dp[i][1] = (dp[i-2][0] + dp[i-2][1]) % 10007;
        }

        long ans = (dp[n][0] + dp[n][1]) % 10007;
        System.out.println(ans);
    }
}

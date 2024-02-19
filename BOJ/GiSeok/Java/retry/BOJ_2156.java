package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[10001];
        int[] wine = new int[10001];

        wine[0] = dp[0] = 0;
        for (int i = 1; i <= n; i++)
            wine[i] = Integer.parseInt(br.readLine());

        dp[1] = wine[1];
        dp[2] = dp[1] + wine[2];

        for (int i = 3; i <= n; i++)
            dp[i] = Math.max(
                Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]),
                dp[i - 1]);

        System.out.println(dp[n]);
    }
}

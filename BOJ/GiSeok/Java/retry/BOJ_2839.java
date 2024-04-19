package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        for (int i = 0; i < N+1; i++) dp[i] = 5001;

        dp[3] = 1;
        if (N >= 5) dp[5] = 1;
        
        for (int i = 6; i < N+1; i++)
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;

        dp[N] = dp[N] >= 5001 ? -1 : dp[N];
        System.out.println(dp[N]);
    }
}

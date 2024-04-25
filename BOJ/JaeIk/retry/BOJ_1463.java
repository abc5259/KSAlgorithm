package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1];
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(dp(n));
    }

    static int dp(int n){
        if(dp[n]==null){
            if(n%6==0){
                dp[n] = Math.min(dp(n/3), Math.min(dp(n/2), dp(n-1))) + 1;
            }
            else if(n%3==0){
                dp[n] = Math.min(dp(n/3), dp(n-1)) + 1;
            }
            else if(n%2==0){
                dp[n] = Math.min(dp(n/2), dp(n-1)) + 1;
            }
            else dp[n] = dp(n-1) + 1;
        }

        return dp[n];
    }
}

package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Long[] dp = new Long[91];
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;

        for(int i=3; i<91; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
    }
}

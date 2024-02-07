package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    static int n;
    static Integer[] dp;
    static int[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        score = new int[n+1];
        for(int i=1; i<=n; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = score[0];

        dp[1] = score[1];

        if(n >= 2) {
            dp[2] = score[1] + score[2];
        }

        System.out.println(solve(n));
    }

    static int solve(int n){
        if(dp[n]==null){
            dp[n] = Math.max(solve(n-2), score[n-1]+solve(n-3)) + score[n];
        }
        return dp[n];
    }
}

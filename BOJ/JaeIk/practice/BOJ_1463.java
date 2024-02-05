package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    static Integer[] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        dp[1] = 0;

        System.out.println(solve(n));
    }

    static int solve(int n){
        if(dp[n]==null){
            if(n%6 == 0){
                dp[n] = Math.min(solve(n/2), Math.min(solve(n/3), solve(n-1)))+1;
            }
            else if(n%2 == 0){
                dp[n] = Math.min(solve(n/2), solve(n-1))+1;
            }
            else if(n%3 == 0){
                dp[n] = Math.min(solve(n/3), solve(n-1))+1;
            }
            else{
                dp[n] = solve(n-1)+1;
            }
        }
        return dp[n];
    }
}

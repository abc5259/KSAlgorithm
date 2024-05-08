package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_2 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1];
        dp[1] = 0;

        for(int i=2; i<=n; i++){
            if(i%6==0){
                dp[i] = Math.min(dp[i-1], Math.min(dp[i/3], dp[i/2])) + 1;
            }
            else if(i%2==0){
                dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
            }
            else if(i%3==0){
                dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
            }
            else{
                dp[i] = dp[i-1] + 1;
            }
        }

        System.out.println(dp[n]);
    }

//    static int dp(int n){
//
//        if(dp[n]==null){
//            //6으로 나눠질 때
//            if(n%6 == 0){
//                dp[n] = Math.min(dp(n-1), Math.min(dp(n/3), dp(n/2)))+1;
//            }
//            //2로 나눠질 때
//            else if(n%2 == 0){
//                dp[n] = Math.min(dp(n/2), dp(n-1))+1;
//            }
//
//            //3으로 나눠질 때
//            else if(n%3 == 0){
//                dp[n] = Math.min(dp(n/3), dp(n-1))+1;
//            }
//
//
//
//            else dp[n] = dp(n-1)+1;
//        }
//
//        return dp[n];
//    }
}

package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[5001];

        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for(int i=6; i<5001; i++){
            if(i%5 == 0){
                dp[i] = dp[i-5] + 1;
            }
            else if(i%3 == 0){
                dp[i] = dp[i-3] + 1;
            }
            else if(dp[i-3]!=0 && dp[i-5]!=0){
                dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
            }
        }

        int answer = (dp[n]==0)?-1:dp[n];

        System.out.println(answer);
    }
}

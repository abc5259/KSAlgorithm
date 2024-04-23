package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
    static int INF = Integer.MAX_VALUE;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[5001];

        dp[3] = 1;
        dp[4] = INF;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = INF;
        dp[8] = 2;

        for(int i=9; i<=5000; i++){
            int base = (dp[i-3] > dp[i-5]) ?i-5 :i-3;

            if(i-base == 3){
                dp[i] = dp[base] + 1;
            }
            else if(i-base == 5){
                dp[i] = dp[base] + 1;
            }
            else dp[i] = INF;
        }

        int answer = (dp[N]==INF)?-1:dp[N];
        System.out.println(answer);
    }
}

package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
    static int[] answer;
    static Integer[] dp;
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new Integer[11];
        arr = new int[n+1];
        answer = new int[n];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            answer[i] = solve(arr[i]);
        }

        for(int i=0; i<n; i++){
            System.out.println(answer[i]);
        }
    }

    static int solve(int n){
        if(dp[n]==null){
            dp[n] = solve(n-1) + solve(n-2) + solve(n-3);
        }
        return dp[n];
    }
}

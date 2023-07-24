package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;
    static int[][] dp;
    static  int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n][3];
        cost = new int[n][3];
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            cost[i][RED]=Integer.parseInt(st.nextToken());
            cost[i][GREEN]=Integer.parseInt(st.nextToken());
            cost[i][BLUE]=Integer.parseInt(st.nextToken());
        }

        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        System.out.println(Math.min(painter(n-1, RED), Math.min(painter(n-1, GREEN), painter(n-1, BLUE))));
    }

    static int painter(int n, int color){
        if(dp[n][color]==0){
            if(color==RED){
                dp[n][RED] = cost[n][RED] + Math.min(painter(n-1,GREEN),  painter(n-1,BLUE));
            }
            else if(color==GREEN){
                dp[n][GREEN] = cost[n][GREEN] + Math.min(painter(n-1,RED), painter(n-1,BLUE));
            }
            else{
                dp[n][BLUE] = cost[n][BLUE] + Math.min(painter(n-1, RED), painter(n-1, GREEN));
            }
        }
        return dp[n][color];
    }
}

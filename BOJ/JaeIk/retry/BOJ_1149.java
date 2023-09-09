package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    static int red = 0;
    static int green = 1;
    static int blue = 2;
    static int n;
    static int[][] dp;
    static int[][] price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        price = new int[n][3];
        dp = new int[n][3];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = 0;
            }
        }

        dp[0][red] = price[0][red];
        dp[0][green] = price[0][green];
        dp[0][blue] = price[0][blue];

        System.out.print(Math.min(solve(n- 1, red), Math.min(solve(n - 1, green), solve(n - 1, blue))));

    }

    static int solve(int n, int color){
        if(dp[n][color]==0){
            if(color==red){
                dp[n][color] = Math.min(solve(n-1, green), solve(n-1, blue)) + price[n][red];
            }
            else if(color==green){
                dp[n][color] = Math.min(solve(n-1, red), solve(n-1, blue)) + price[n][green];
            }
            else if(color==blue){
                dp[n][color] = Math.min(solve(n-1, green), solve(n-1, red)) + price[n][blue];
            }
        }
        return dp[n][color];
    }
}


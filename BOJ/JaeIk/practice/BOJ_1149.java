package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;
    static Integer[][] dp;
    static int n;
    static int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1][3];
        cost = new int[n+1][3];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        //각 색에 대해 solve를 세 번 하고 그 중 가장 작은 값을 출력
        int r = solve(n, RED);
        int g = solve(n, GREEN);
        int b = solve(n, BLUE);

        int answer = Math.min(r, Math.min(g, b));

        System.out.println(answer);
    }

    //dp[n] -> n개의 집을 칠하는 최솟값
    static int solve(int n, int color){
        if(dp[n][color] == null){
            if(color == RED){
                dp[n][color] = Math.min(solve(n-1, GREEN), solve(n-1, BLUE)) + cost[n][color];
            }
            else if(color == GREEN){
                dp[n][color] = Math.min(solve(n-1, RED), solve(n-1, BLUE)) + cost[n][color];
            }
            else{
                dp[n][color] = Math.min(solve(n-1, GREEN), solve(n-1, RED)) + cost[n][color];
            }
        }

        return dp[n][color];
    }
}

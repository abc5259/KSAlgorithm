package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1932 {
    static int n;
    static int[][] triangle;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1][n+1];
        triangle = new int[n+1][n+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<=i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];

        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][0] + triangle[i][j];
                }
                else if(j==i){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else {
                    dp[i][j] = Math.max((dp[i-1][j-1]+triangle[i][j]), (dp[i-1][j]+triangle[i][j]));
                }

            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(dp[n-1][i] > max)max = dp[n-1][i];
        }
        System.out.println(max);
    }

    /**
     *
     * 00
     * 10 11
     * 20 21 22
     * 30 31 32 33
     */

    //dp[i][j] -> i j 까지 원소의 합 최댓 값

}

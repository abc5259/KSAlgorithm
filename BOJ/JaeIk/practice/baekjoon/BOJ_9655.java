package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9655 {
    static int[] dp; //인덱스가 홀수면 상근 승
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;

        for(int i=4; i<1001; i++){
            if(dp[i-1]==1 && dp[i-3]==1)dp[i]=0;
            else dp[i]=1;
        }

        String answer = (dp[N]%2 == 0)?"CY":"SK";

        System.out.println(answer);
    }
}

package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //i를 제곱수 j개로 표현
        int[] dp = new int[N+1];
        dp[1] = 1;

        int min = 0;
        for(int i=2; i<=N; i++){
            min = Integer.MAX_VALUE;

            for(int j=1; j*j<=i; j++){
                int temp = i-j*j;
                min = Math.min(min, dp[temp]);
            }

            dp[i] = dp[min]+1;
        }

        System.out.println(dp[N]);
    }
}

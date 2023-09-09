package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904 {
    static int[] dp = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(solve(n));
    }

    static int solve(int n){
        //만약 배열에 값이 없으면 계산후 저장해야한다
        if(dp[n] == -1)dp[n] = (solve(n-1) + solve(n-2)) % 15746;
        return dp[n];
    }
}

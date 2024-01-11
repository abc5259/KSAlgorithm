package BOJ.GiSeok.Java.retry;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        // i번째 자리 뒤에 1~9 가 올 수 있는 경우의 수
        dp[1][0] = 0;
        for (int i = 1; i < 10; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    dp[i][j] = dp[i-1][j+1];
                else if (j == 9)
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++)
            ans = (ans + dp[N][i]) % 1000000000;
        
        System.out.println(ans);
    }
}

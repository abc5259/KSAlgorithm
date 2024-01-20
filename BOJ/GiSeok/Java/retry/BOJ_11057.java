package BOJ.GiSeok.Java.retry;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

        for (int i = 0; i < 10; i++)
            dp[1][i] = 1;

        for (int i = 2; i < N+1; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = 0;
                for (int z = 0; z <= j; z++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][z]) % 10007;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 10; i++)
            ans = (ans + dp[N][i]) % 10007;

        System.out.println(ans);
    }
}

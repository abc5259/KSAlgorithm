package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4; i<101; i++) {
            dp[i] = dp[i-1] + 1;
            int cnt = 2;
            for(int j=3; j<=6;j++) {
                if(i-j < 0) break;
                dp[i] = Math.max(dp[i], dp[i-j] * cnt++);
            }
        }
        System.out.println(dp[N]);
    }
}

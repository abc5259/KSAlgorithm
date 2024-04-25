package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            dp = new Integer[12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            sb.append(dp(n)).append("\n");
        }

        System.out.print(sb);
    }

    static int dp(int n){
        if(dp[n] == null) {
            dp[n] = dp(n-1)+dp(n-2)+dp(n-3);
        }
        return dp[n];
    }
}

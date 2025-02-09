package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[1001];
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = false;

        for(int i=5; i<1001; i++) {
            if(!dp[i-1] || !dp[i-3]) dp[i] = true;
            else dp[i] = false;
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}

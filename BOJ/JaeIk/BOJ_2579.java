package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    static int n;
    static int[] val;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        val = new int[n+1];
        dp = new int[n+1];

        for(int i=1; i<=n; i++){
            val[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = val[1];

        if(n>=2){
            dp[2] = val[1]+val[2];
        }

        for(int i=3; i<=n; i++){
                dp[i] = Math.max(dp[i-2], dp[i-3] + val[i-1]) + val[i];
        }

        System.out.println(dp[n]);
    }
}

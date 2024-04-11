package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Knapsack {
    static Integer[][] dp;
    static int[] v;
    static int[] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            v = new int[n];
            c = new int[n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }

            dp = new Integer[n][k+1];

            System.out.println("#"+(tc+1)+" "+dp(n-1, k));
        }
    }

    static int dp(int i, int k){
        if(i<0){
            return 0;
        }

        if(dp[i][k] == null){
            if(v[i]>k){
                dp[i][k] = dp(i-1, k);
            }
            else {
                dp[i][k] = Math.max(dp(i-1, k), dp(i-1, k-v[i])+c[i]);
            }
        }

        return dp[i][k];
    }
}

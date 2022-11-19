package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_22871 {
  static int n,k=0;
    static long[] arr, dp;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        dp = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i =0;i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            dp[i] = -1;
        }
        System.out.println(solve(0));

    }
    public static long solve(int x){
        if (x==n-1) return 0;
        if (dp[x] != -1) {
            return dp[x];
        }
        dp[x] = Long.MAX_VALUE;

        for(int i=x+1;i<n;i++){
            dp[x] = Math.min(dp[x], Math.max(solve(i),(i-x)*(1+Math.abs(arr[x]-arr[i]))));
        }
        return dp[x];
    }
}

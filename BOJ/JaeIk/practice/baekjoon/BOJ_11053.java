package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] = 1;

            for(int j=1; j<=i; j++){
                if(arr[i]>arr[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int result = -1;
        for(int i=1; i<=n; i++){
            result = Math.max(result, dp[i]);
        }
        System.out.print(result);
    }
}

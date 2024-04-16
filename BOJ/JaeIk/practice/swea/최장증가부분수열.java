package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class 최장증가부분수열 {
    static Integer[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp = new Integer[n];
            for(int i=0; i<n; i++){
                LIS(i);
            }

            int longest=-1;
            for(int i=0; i<n; i++){
                longest = Math.max(longest, dp[i]);
            }

            System.out.println("#"+(tc+1)+" "+longest);
        }
    }

    static int LIS(int n){
        if(dp[n] == null){
            dp[n] = 1;

            for(int i=n-1; i>=0; i--){
                if(arr[n] > arr[i]){
                    dp[n] = Math.max(dp[n], LIS(i)+1);
                }
            }
        }

        return dp[n];
    }
}

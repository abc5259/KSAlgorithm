package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class 최장증가부분수열 {
    static int[] dp;
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

            dp = new int[n];
            for(int i=0; i<n; i++){
               dp[i] = 1;

               for(int j=0; j<i; j++){

                   if(arr[j]<arr[i] && dp[i] < dp[j]+1){
                       dp[i] = dp[j]+1;
                   }
               }
            }

            int longest=-1;
            for(int i=0; i<n; i++){
                longest = Math.max(longest, dp[i]);
            }

            System.out.println("#"+(tc+1)+" "+longest);
        }
    }
}

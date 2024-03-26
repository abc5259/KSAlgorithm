package BOJ.JaeIk.practice.swea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class 햄버거다이어트
{
    static Integer[][] dp;
    static int n, l;
    static int[] w;
    static int[] v;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            w = new int[n];
            v = new int[n];

            dp = new Integer[n][l+1];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                w[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println("#"+(tc+1)+" "+dp(n-1, l));
        }
    }

    static int dp(int i, int l) {
        if(i<0)return 0;

        if(dp[i][l] == null) {
            if(w[i]>l) {
                dp[i][l] = dp(i-1, l);
            }else {
                dp[i][l] = Math.max(dp(i-1, l), dp(i-1, l-w[i])+v[i]);
            }
        }

        return dp[i][l];
    }
}
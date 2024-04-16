package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[30][30];
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            sb.append(combination(m, n)).append("\n");
        }

        System.out.print(sb);
    }

    static int combination(int n, int r){
         //저장되어있는 경우 바로 반환
         if(dp[n][r]>0){
             return dp[n][r];
         }

         //2번 성질
         if(n==r || r==0)return dp[n][r] = 1;

         //1번 성질
         return combination(n-1, r-1)+combination(n-1, r);
    }
}

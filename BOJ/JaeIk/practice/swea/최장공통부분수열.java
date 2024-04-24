package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최장공통부분수열 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] a = st.nextToken().toCharArray();
            char[] b = st.nextToken().toCharArray();

            dp = new int[a.length+1][b.length+1];
            dp[0][0] = 0;

            for(int i=0; i<a.length; i++){
                for(int j=0; j<b.length; j++){
                    if(a[i] == b[j]){
                        dp[i+1][j+1] = dp[i][j] + 1;
                    } else {
                        dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                    }
                }
            }

            int answer = dp[a.length][b.length];

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }
}

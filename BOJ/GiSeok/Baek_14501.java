/*
백준 - 14501 퇴사 (05/20 금) 

*/
package BOJ.GiSeok;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baek_14501 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][N + 2];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[0][i] = Integer.parseInt(st.nextToken());
            dp[1][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            if (i + (dp[0][i]-1) > N)
                dp[1][i] = 0;
            else {
                int max = 0;
                for (int j = (i + dp[0][i]); j < N + 1; j++)         
                    max = Math.max(max, dp[1][j]);
                dp[1][i] += max;
            }
        }

        int max = dp[1][1];
        for (int i = 2; i < N + 1; i++) {
            max = Math.max(max, dp[1][i]);
        }

        System.out.println(max);
    }
}
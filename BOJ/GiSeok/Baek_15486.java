/*
백준 - 15486 퇴사 2 (05/21 토) 

*/
package BOJ.GiSeok;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baek_15486 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 2][2];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            int Ti = i + dp[i][0];
            if (Ti > N+1)
                dp[i][1] = dp[i+1][1];
            else {
                dp[i][1] = Math.max(dp[i][1] + dp[Ti][1], dp[i+1][1]);
            }
        }

        int max = dp[1][1];
        for (int i = 2; i < N + 1; i++) {
            max = Math.max(max, dp[i][1]);
        }

        System.out.println(max);
    }
}
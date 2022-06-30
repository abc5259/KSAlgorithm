/*
백준 - 14501 퇴사 (05/20 금) 

*/
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Baek_14501 {
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
            int Ti = i + (dp[i][0]-1);
            if (Ti > N)
                dp[i][1] = 0;
            else {
                int max = 0;
                for (int j = (Ti + 1); j < N + 1; j++)         
                    max = Math.max(max, dp[j][1]);
                dp[i][1] += max;
            }
        }

        int max = dp[1][1];
        for (int i = 2; i < N + 1; i++) {
            max = Math.max(max, dp[i][1]);
        }

        System.out.println(max);
    }
}
/*
백준 - 9461 파도반 수열 (05/19 목)

*/
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_9461 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i < 101; i++)
            dp[i] = dp[i-1] + dp[i-5];

        for (int i = 0; i < N; i++) {
            int T = Integer.parseInt(br.readLine());
            System.out.println(dp[T]);
        }
        
    }
}
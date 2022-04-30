/*
백준 - 2748 피보나치 수 2 (05/19 목)

*/
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_2748 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 2];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < N + 1; i++)
            dp[i] = dp[i-1] + dp[i-2];

        System.out.println(dp[N]);
    }
}
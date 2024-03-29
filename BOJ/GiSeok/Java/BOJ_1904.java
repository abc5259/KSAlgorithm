/*
BaekJoon - 1904 01타일 (05/09 월) 

n=1부터 구해보면 피보나치 수열임을 알 수 있다.
*/
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+2];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < N + 1; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;

        System.out.println(dp[N]);
    }
}
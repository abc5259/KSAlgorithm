/*
BaekJoon - 10844 쉬운 계단 수 (05/10 화) 

*/
package BOJ.GiSeok;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baek_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];

        for (int j = 0; j < 10; j++)
            dp[1][j] = 1;

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    dp[i][j] = dp[i-1][j+1] % 1000000000l;
                else if (j == 9)
                    dp[i][j] = dp[i-1][j-1] % 1000000000l;
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000l;
            }
        }

        long num = 0;
        for (int j = 1; j < 10; j++)
            num = (num + dp[N][j]) % 1000000000l;

        System.out.println(num);
    }
}
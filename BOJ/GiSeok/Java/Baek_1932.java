/*
BaekJoon - 1932 정수 삼각형 (05/11 수) 

*/
package BOJ.GiSeok.Java;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baek_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 2][N + 2];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++)
                dp[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0)
                    dp[i][j] = dp[i-1][0] + dp[i][0];
                else if (j == (i-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j-1] + dp[i][j], dp[i-1][j] + dp[i][j]);
            }
        }

        int num = dp[N][0];
        for (int i = 1; i < N; i++)
            num = Math.max(num, dp[N][i]);

        System.out.println(num);
    }
}
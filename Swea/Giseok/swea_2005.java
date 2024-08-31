/**
 * 2005. 파스칼의 삼각형 [성공|00:11:13]
 * D2, 구현, 시도2
 */
package Swea.Giseok;
import java.io.*;

public class swea_2005
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n][n];

            dp[0][0] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) dp[i][j] = dp[i-1][j];
                    else if (j == i) dp[i][j] = dp[i-1][j-1];
                    else dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
            }

            System.out.println("#" + test_case);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
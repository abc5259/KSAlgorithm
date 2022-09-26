/*
백준 - 9465 스티커 (05/27 금)

*/
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int Tcase = Integer.parseInt(br.readLine());
        int[][] dp;

        for (int c = 0; c < Tcase; c++) {
            int N = Integer.parseInt(br.readLine());
            dp = new int[2][N + 1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N + 1; j++)
                    dp[i][j] = Integer.parseInt(st.nextToken());
            }


            for (int i = 2; i < N + 1; i++) {
                dp[0][i] = Math.max(dp[1][i-1] + dp[0][i], dp[1][i-2] + dp[0][i]);
                dp[1][i] = Math.max(dp[0][i-1] + dp[1][i], dp[0][i-2] + dp[1][i]);
            }

            bw.write(Math.max(dp[0][N], dp[1][N]) + "\n");
        }
        

        bw.flush();
        bw.close();
    }
}
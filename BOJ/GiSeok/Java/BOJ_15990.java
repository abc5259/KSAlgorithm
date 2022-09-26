/*
백준 - 15990 1, 2, 3 더하기 5 (05/30 월)

*/
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BOJ_15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[100001][4];

        dp[1][1] = 1;

        dp[2][2] = 1;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < 100001; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
            dp[i][3] = (dp[i-3][2] + dp[i-3][1]) % 1000000009;
        }

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(((dp[num][1] + dp[num][2] + dp[num][3]) % 1000000009) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
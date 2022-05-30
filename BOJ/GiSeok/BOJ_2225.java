/*
백준 - 2225 합분해 (05/30 월)

*/
package BOJ.GiSeok;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N + 1][K + 1];
        
        for (int i = 1; i < K + 1; i++)
            dp[0][i] = 1;

        for (int i = 1; i < N + 1; i++) {
            dp[i][1] = 1;
            for (int j = 2; j < K + 1; j++)
                for (int z = i; z >= 0; z--)
                    dp[i][j] = (dp[i][j] + dp[z][j - 1]) % 1000000000;
        }

        bw.write(dp[N][K] % 1000000000 + "\n");

        bw.flush();
        bw.close();
    }
}
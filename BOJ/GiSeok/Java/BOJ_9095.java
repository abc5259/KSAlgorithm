/*
BaekJoon - 9095 1, 2, 3 더하기 (05/04 수)

특정 수의 1, 2, 3으로 만든 더하기 횟수는 dp[x-3] + dp[x-2] + dp[x-1]과 같음
 */
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BOJ_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(dp[num] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
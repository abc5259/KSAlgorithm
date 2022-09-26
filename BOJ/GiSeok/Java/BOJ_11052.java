/*
백준 - 11052 카드 구매하기 (05/24 화)

*/
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_11052 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i < N + 1; i++) {
            int max = dp[i];
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dp[i - j] + dp[j]);
            }
            dp[i] = max;
        }

        bw.write(dp[N] + "\n");
        
        bw.flush();
        bw.close();
    }
}
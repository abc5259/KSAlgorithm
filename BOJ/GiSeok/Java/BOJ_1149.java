/*
BaekJoon - 1149 RGB 거리 (05/06 금)

R, G, B 중에 n번째가 R을 골랐다고 가정하면, 이전 n-1번째는 G, B 중 하나이고
G를 골랐다면 R, B 중 하나, B를 골랐다면 R, G 중 하나를 선택했을 것이다.

이를 이용해서 R을 골랐을 때, G, B를 더한 것 중 최소값,
G를 골랐을 때, R, B를 더한 것 중 최소값,
B를 골랐을 때, R, G를 더한 것 중 최소값을 모아

마지막에 이 셋 중 젤 작은 값을 선택하면 됨.
*/
package BOJ.GiSeok.Java;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Baek_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
            dp[i][2] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 2; i < N+1; i++) {
            dp[i][0] = Math.min((dp[i-1][1] + dp[i][0]), (dp[i-1][2] + dp[i][0]));
            dp[i][1] = Math.min((dp[i-1][0] + dp[i][1]), (dp[i-1][2] + dp[i][1]));
            dp[i][2] = Math.min((dp[i-1][0] + dp[i][2]), (dp[i-1][1] + dp[i][2]));
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));

        bw.flush();
        bw.close();
    }
}
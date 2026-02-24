package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1328 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    long[][][] dp = new long[N+1][101][101];
    dp[1][1][1] = 1;
    dp[2][1][2] = 1;
    dp[2][2][1] = 1;
    for(int i=3; i<=N; i++) {
      for(int l=1; l<=L; l++) {
        for(int r=1; r<=R; r++) {
          dp[i][l][r] = dp[i-1][l-1][r];
          dp[i][l][r] = (dp[i][l][r] + dp[i-1][l][r-1]) % 1000000007;
          dp[i][l][r] = (dp[i][l][r] + dp[i-1][l][r] * (i-2)) % 1000000007;
        }
      }
    }

    System.out.println(dp[N][L][R]);
  }
}

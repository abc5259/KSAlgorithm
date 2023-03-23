package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    int[][] dp = new int[N+1][3];

    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      int red = Integer.parseInt(st.nextToken());
      int green = Integer.parseInt(st.nextToken());
      int blue = Integer.parseInt(st.nextToken());

      dp[i][0] = red + Math.min(dp[i-1][1], dp[i-1][2]);
      dp[i][1] = green + Math.min(dp[i-1][0], dp[i-1][2]);
      dp[i][2] = blue + Math.min(dp[i-1][0], dp[i-1][1]);
    }

    System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    
  }
}

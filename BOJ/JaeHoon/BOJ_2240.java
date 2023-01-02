package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2240 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());

    int[][][] dp = new int[T+1][3][W+1];
    int n = Integer.parseInt(br.readLine());

    if(n == 1) {
      dp[1][1][0] = 1;
    }else {
      dp[1][2][1] = 1;
    }

    for(int i=2; i<=T; i++) {
      int tree = Integer.parseInt(br.readLine());

      if(tree == 1) {
        dp[i][1][0] = dp[i-1][1][0] + 1;
        for(int j=1; j<=W; j++) {
          dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][2][j-1]) + 1;
          dp[i][2][j] = Math.max(dp[i-1][1][j-1], dp[i-1][2][j]);
        }
      }

      else {
        dp[i][2][0] = dp[i-1][2][0]+1;
        for(int j=1; j<=W; j++) {
          dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][2][j-1]); 
          dp[i][2][j] = Math.max(dp[i-1][1][j-1], dp[i-1][2][j]) + 1;
        }
      }
    }
    int answer = 0;
    for(int i=1; i<=W; i++) {
      answer = Math.max(answer, Math.max(dp[T][1][i], dp[T][2][i]));
    }
    System.out.println(answer);
  }
}

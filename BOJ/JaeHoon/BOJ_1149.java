package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_1149 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] dp = new int[N+1][4];
    for(int i=1; i<N+1; i++) {
      for(int j=1; j<4; j++) {
        dp[i][j] = sc.nextInt();
      }
    }

    for(int i=2; i<N+1; i++) {
      dp[i][1] = Math.min(dp[i-1][3] + dp[i][1], dp[i-1][2] + dp[i][1]);
      dp[i][2] = Math.min(dp[i-1][1] + dp[i][2], dp[i-1][3] + dp[i][2]);
      dp[i][3] = Math.min(dp[i-1][1] + dp[i][3], dp[i-1][2] + dp[i][3]);
    }
    int result = Math.min(dp[N][1], Math.min(dp[N][2], dp[N][3]));
    System.out.println(result);
  }
}

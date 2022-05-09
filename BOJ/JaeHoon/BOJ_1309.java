package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_1309 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] dp = new int[N+1][3];
    int MOD = 9901;
    dp[1][0] = dp[1][1] = dp[1][2] = 1;
    for(int i=2; i<N+1; i++) {
      dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
      dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
      dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
    }
    System.out.println((dp[N][0] + dp[N][1] + dp[N][2])% MOD);
  }
}

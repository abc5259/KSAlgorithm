package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_2225 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int[][] dp = new int[201][201];
    for(int i=0; i<=N; i++) {
      dp[1][i] = 1;
    }
    for(int i=1; i<=K; i++) {
      for(int j=0; j<=N; j++) {
        for(int l=0; l<=j; l++) {
          dp[i][j] += dp[i-1][j-l];
          dp[i][j] %= 1_000_000_000;
        }
      }
    }
    System.out.println(dp[K][N]);
  }
}
 
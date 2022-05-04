package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_2193 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    long[][] dp = new long[91][2];
    dp[1][0] = 0;
    dp[1][1] = 1;
    for(int i=2; i<=90; i++) {
      dp[i][0] = dp[i-1][0] + dp[i-1][1];
      dp[i][1] = dp[i-1][0];
    }
    System.out.println(dp[N][0] + dp[N][1]);
  }
}

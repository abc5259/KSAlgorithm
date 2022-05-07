package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_15988 {
  static long[][] dp = new long[1_000_001][4];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    getDP();
    int T = sc.nextInt();
    for(int i=0; i<T; i++) {
      int N = sc.nextInt();
      sb.append((dp[N][1] + dp[N][2] + dp[N][3])% 1_000_000_009).append("\n");
    }
    System.out.println(sb);
  }
  static void getDP() {
    dp[1][1] = 1;
    dp[2][1] = 1;
    dp[2][2] = 1;
    dp[3][1] = 2;
    dp[3][2] = 1;
    dp[3][3] = 1;
    for(int j=4; j<=1_000_000; j++) {
      dp[j][1] = (dp[j-1][1] + dp[j-1][2] + dp[j-1][3]) % 1_000_000_009;
      dp[j][2] = (dp[j-2][1] + dp[j-2][2] + dp[j-2][3]) % 1_000_000_009;
      dp[j][3] = (dp[j-3][1] + dp[j-3][2] + dp[j-3][3]) % 1_000_000_009;
    }
  }
}

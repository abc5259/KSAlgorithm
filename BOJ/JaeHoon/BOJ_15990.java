package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_15990 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    int T = sc.nextInt();
    long[][] dp = new long[100001][4];
    dp[1][1] = 1;
    dp[2][2] = 1;
    dp[3][1] = 1;
    dp[3][2] = 1;
    dp[3][3] = 1;
    for(int i=4; i<100001; i++) {
      dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1_000_000_009;
      dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1_000_000_009;
      dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1_000_000_009;
    }
    for(int i=0; i<T; i++) {
      int N = sc.nextInt();
      sb.append((dp[N][1] + dp[N][2] + dp[N][3]) % 1_000_000_009).append("\n");
    }
    System.out.println(sb);
  }
}

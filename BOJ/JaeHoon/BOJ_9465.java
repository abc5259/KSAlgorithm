package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_9465 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    int T = sc.nextInt();
    for(int i=0; i<T; i++) {
      int N = sc.nextInt();
      int[][] arr = new int[2][N+1];
      for(int j=0; j<2; j++) {
        for(int k=1; k<N+1; k++) {
          arr[j][k] = sc.nextInt();
        }
      }
      sb.append(getDP(arr, N)).append("\n");
    }
    System.out.println(sb);
  }
  static int getDP(int[][] arr, int N) {
    int[][] dp = new int[N+1][2];
    dp[1][0] = arr[0][1];
    dp[1][1] = arr[1][1];
    for(int i=2; i<N+1; i++) {
      dp[i][0] = Math.max(dp[i-2][1],dp[i-1][1]) + arr[0][i];
      dp[i][1] = Math.max(dp[i-2][0],dp[i-1][0]) + arr[1][i];
    }
    return Math.max(dp[N][0], dp[N][1]);
  }
}

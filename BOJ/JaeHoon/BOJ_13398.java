package BOJ.JaeHoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_13398 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    int[][] dp = new int[N][2];
    for(int i = 0; i<N; i++) {
      arr[i] = sc.nextInt();
    }
    dp[0][0] = dp[0][1] =arr[0];
    int max = dp[0][0];
    for(int i=1; i<N; i++) {
      dp[i][0] = Math.max(arr[i], arr[i] + dp[i-1][0]);
      dp[i][1] = Math.max(dp[i-1][0], arr[i] + dp[i-1][1]);
      max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
    }
    System.out.println(max);
  }
}

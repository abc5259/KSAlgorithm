package BOJ.JaeHoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1699 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int num = 1;
    int[] dp = new int[N+1];
    dp[1] = 1;
    for(int i=1; i<=N; i++) {
      dp[i] = dp[i-1] + dp[1];
      if(i == num * num) {
        num++;
        dp[i] = 1;
        continue;
      }
      for(int j=1; j<=i/2; j++) {
        dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
      }
    }
    System.out.println(dp[N]);
  }
}

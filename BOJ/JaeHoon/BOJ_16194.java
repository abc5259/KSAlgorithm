package BOJ.JaeHoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16194 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] dp = new int[N+1];
    int[] p = new int[N+1];
    for(int i=1; i<=N; i++) {
      p[i] = sc.nextInt();
    }
    for(int i=1; i<=N; i++) {
      for(int j=1; j<=i; j++) {
        if(j == 1) {
          dp[i] = p[1] + dp[i-1];
          continue;
        }
        dp[i] = Math.min(dp[i], p[j] + dp[i-j]);
      }
    }
    System.out.println(dp[N]);
  }
}

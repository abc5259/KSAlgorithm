package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_11057 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] dp = new int[N+1][10];
    for(int i=0; i<10; i++) {
      dp[1][i] = 1;
    }
    for(int i=2; i<N+1; i++) {
      for(int j=0; j<10; j++) {
        for(int l=0; l<=j; l++) {
          dp[i][j] += dp[i-1][l];
          dp[i][j] %= 10_007;
        }
      }
    }
    int sum = 0;
    for(int i=0; i<10; i++) {
      sum += dp[N][i];
      sum %= 10_007;
    }
    System.out.println(sum);
  }
}

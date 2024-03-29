package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_10844 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] dp = new int[101][10];
    for(int i=1; i<=9; i++) {
      dp[1][i] = 1;
    }
    for(int i=2; i<=N; i++) {
      for(int j=0; j<=9; j++) {
        if(j == 0) {
          dp[i][j] = dp[i-1][j+1] % 1_000_000_000;
        }
        else if(j == 9) {
          dp[i][j] = dp[i-1][j-1] % 1_000_000_000;
        }else {
          dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000;
        }
      }
    }
    int sum = 0;
    for(int i=0; i<10; i++) {
      sum += dp[N][i];
      sum %= 1_000_000_000;
    }
    System.out.println(sum);
  }
}

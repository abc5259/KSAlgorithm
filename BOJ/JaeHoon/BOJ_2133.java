package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_2133 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] dp = new int[31];
    dp[2] = 3;
    for(int i=4; i<31; i+=2) {
      dp[i] = dp[i-2] * 3 + 2;
      for(int j=4; j<i; j+=2) {
        dp[i] += dp[i-j] * 2;
      }
    }
    System.out.println(dp[N]);
  }
}

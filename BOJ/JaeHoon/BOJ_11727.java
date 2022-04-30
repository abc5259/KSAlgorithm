package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_11727 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] dp = new int[1001];
    dp[1] = 1;
    dp[2] = 3;
    dp[3] = 5;
    for(int i=4; i<dp.length; i++) {
      dp[i] = (dp[i-1] + 2 * dp[i-2])%10007;
    }
    System.out.println(dp[N]);
  }
}

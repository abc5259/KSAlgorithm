package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9657 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[1001];
    dp[1] = 1;
    dp[2] = 0;
    dp[3] = 1;
    dp[4] = 1;

    for(int i=5; i<=1000; i++) {
      if(dp[i-1] == 0 || dp[i-3] == 0 || dp[i-4] == 0) dp[i] = 1;
      else dp[i] = 0;
    }

    System.out.println(dp[N] == 1 ? "SK" : "CY");
  }
}

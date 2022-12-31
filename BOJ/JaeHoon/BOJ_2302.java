package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2302 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int total = 1;
    int[] dp = new int[41];
    dp[0] = dp[1] = 1;
    dp[2] = 2;
    for(int i=3; i<=40; i++)  {
      dp[i] = dp[i-1] + dp[i-2];
    }
    int prev = 0;
    for(int i= 0; i<M; i++)  {
      int num = Integer.parseInt(br.readLine());
      total *= dp[num - prev - 1];
      prev = num;
    }
    total *= dp[N - prev];
    
    
    System.out.println(total);
  }
}

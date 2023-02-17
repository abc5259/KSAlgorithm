package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1720 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    long[] dp = new long[30+1];
    dp[1] = 1;
    dp[2] = 3;  
    for(int i=3; i<=N; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] * 2;
    }
    if(N == 1) System.out.println(1);
    else if(N == 2) System.out.println(3);
    else if(N == 3) System.out.println(3);
    else if(N % 2 == 0) {
      System.out.println((dp[N] + (dp[N/2] + dp[(N-2)/2]*2))/2);
    }else {
      System.out.println((dp[N/2] + dp[N]) / 2);
    }
  }
}

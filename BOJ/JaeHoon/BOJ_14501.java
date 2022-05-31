package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] T = new int[N+1];
    int[] P = new int[N+1];
    int[] dp = new int[N+2];
    for(int i=1; i<N+1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }
    for(int i=N; i>0; i--) {
      if(T[i] + i <= N + 1) {
        dp[i] = Math.max(dp[i+1], P[i] + dp[i + T[i]]);
      }else {
        dp[i] = dp[i+1];
      }
    }
    System.out.println(dp[1]);
  }
}

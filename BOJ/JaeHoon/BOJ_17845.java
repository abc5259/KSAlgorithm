package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17845 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] dp = new int[N+1];
    for(int i=0; i<K; i++) {
      st = new StringTokenizer(br.readLine());
      int important = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());

      for(int T=N; T>=0; T--) {
        if(T + time <= N && dp[T] > 0) {
          dp[T+time] = Math.max(dp[T+time], dp[T] + important);
        }
      }
      if(time <= N) dp[time] = Math.max(dp[time], important);
    }
    int max = Integer.MIN_VALUE;
    for(int i=1; i<=N; i++) { 
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}

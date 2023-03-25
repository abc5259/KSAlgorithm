package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] dp = new int[K+1];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      for(int j=K; j>=1; j--) {

        if(j + w <= K) {
          dp[j+w] = Math.max(dp[j+w], dp[j] + v);
        }
      }
      if(w <= K) dp[w] = Math.max(dp[w], v);
    }
    int max = 0;
    for(int i=0; i<=K; i++) {
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }
}

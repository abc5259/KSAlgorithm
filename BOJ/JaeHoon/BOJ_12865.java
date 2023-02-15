package BOJ.JaeHoon;

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
    int[] dp = new int[100000+1];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      for(int j=K; j>=0; j--) {
        if(j+W <= K && dp[j] != 0) {
          dp[j+W] = Math.max(dp[j+W], dp[j] + V);
        }
      }
      dp[W] = Math.max(dp[W], V);
    }
    int max = 0;
    for(int i=0; i<=K; i++) {
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }
}

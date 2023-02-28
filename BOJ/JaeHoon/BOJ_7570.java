package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7570 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N+1];
    int[] dp = new int[N+1];
    for(int i=1; i<=N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for(int i=1; i<=N; i++) {
      dp[arr[i]] = dp[arr[i]-1] + 1;
    }
    int max = Integer.MIN_VALUE;
    for(int i=1; i<=N; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(N - max);
  }
}

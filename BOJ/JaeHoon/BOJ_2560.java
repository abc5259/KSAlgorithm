package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2560 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[] dp = new int[N+1];

    for(int i=0; i<a; i++) dp[i] = 1;

    for(int i=a; i<=N; i++) {
      dp[i] = (dp[i-1] + dp[i-a]) % 1000;
      if(i>=b) dp[i] = (dp[i] - dp[i-b] + 1000) % 1000;
    }
    if(N>=d) dp[N] = (dp[N] - dp[N-d] + 1000) % 1000;
    System.out.println(dp[N]);
  }
}

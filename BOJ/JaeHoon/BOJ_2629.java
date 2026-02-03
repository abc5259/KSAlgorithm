package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2629 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());//
    int[] arr = new int[N+1];
    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

    int cnt = Integer.parseInt(br.readLine());
    int[] ballArr = new int[cnt+1];
    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=cnt; i++) ballArr[i] = Integer.parseInt(st.nextToken());

    boolean[][] dp = new boolean[N+1][15001];
    dp[1][arr[1]] = true;
    for(int i=2; i<=N; i++) {
      dp[i][arr[i]] = true;
      for(int j=1; j<=15000; j++) {
        if(!dp[i-1][j]) continue;

        dp[i][j] = true;
        dp[i][j + arr[i]] = true;
        dp[i][Math.abs(j - arr[i])] = true;
      }
    }

    StringBuffer sb = new StringBuffer();
    for(int i=1; i<=cnt; i++) {
      if(ballArr[i] > 15000) {
        sb.append("N ");
        continue;
      }
      if(dp[N][ballArr[i]]) {
        sb.append("Y ");
      }else {
        sb.append("N ");
      }
    }
    System.out.println(sb);
  }
}

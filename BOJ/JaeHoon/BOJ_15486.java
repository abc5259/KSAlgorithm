package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    
    int[][] consultings = new int[N+1][2];

    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      consultings[i][0] = Integer.parseInt(st.nextToken()); //t
      consultings[i][1] = Integer.parseInt(st.nextToken()); //p
    }
    
    int[] dp = new int[N+2];


    for(int i=1; i<=N; i++) {
      int nextDay = i + consultings[i][0];
      if(nextDay <= N+1) {
        dp[nextDay] = Math.max(dp[i] + consultings[i][1], dp[nextDay]);
      }

      dp[i+1] = Math.max(dp[i], dp[i+1]);
    }

    System.out.println(dp[N+1]);
    
  }
}

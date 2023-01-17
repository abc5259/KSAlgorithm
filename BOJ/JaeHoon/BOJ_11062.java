package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11062 {
  static int[][][] dp;
  static int[] cards;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int T = Integer.parseInt(st.nextToken());
    for(int t=0; t<T; t++) {
      int N = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      cards = new int[N+1];
      dp = new int[2][1001][1001];
      for(int i=1; i<=N; i++) {
        cards[i] = Integer.parseInt(st.nextToken());
      }
      
      sb.append(solve(1, N, 0)+"\n");
    }
    System.out.println(sb);
  }
  public static int solve(int left, int rigth, int flag) {
    if(left == rigth) {
      if(flag == 0)
        return dp[flag][left][rigth] = cards[left];
      else 
        return dp[flag][left][rigth] = 0;
    }

    if(dp[flag][left][rigth] != 0)  return dp[flag][left][rigth];

    if(flag == 0) 
      return dp[flag][left][rigth] = Math.max(solve(left+1, rigth, 1) + cards[left], solve(left, rigth-1, 1) + cards[rigth]);
    else 
      return dp[flag][left][rigth] = Math.min(solve(left+1, rigth, 0), solve(left, rigth-1, 0));
  }
}

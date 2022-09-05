package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12869 {
  static int[] scvs;
  static int[][] pattern = {{-9,-3,-1},{-9,-1,-3},{-3,-9,-1},{-3,-1,-9},{-1,-3,-9},{-1,-9,-3}};
  static int[][][] dp = new int[61][61][61];
  static int minCnt = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    scvs = new int[3];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      scvs[i] = Integer.parseInt(st.nextToken());
    }
    dfs(scvs, 0);
    System.out.println(minCnt);
  }
  public static void dfs(int[] scv,int cnt) {
    if(minCnt <= cnt) return;
    if(dp[scv[0]][scv[1]][scv[2]] != 0 && dp[scv[0]][scv[1]][scv[2]] <= cnt) return;
    dp[scv[0]][scv[1]][scv[2]] = cnt;

    if(scv[0] == 0 && scv[1] == 0 && scv[1] == 0) {
      minCnt = Math.min(minCnt, cnt);
      return;
    }

    for(int i=0; i<6; i++) {
      dfs(new int[] {Math.max(scv[0]+pattern[i][0], 0),Math.max(scv[1]+pattern[i][1], 0),Math.max(scv[2]+pattern[i][2], 0)},cnt+1);
    }
  }
}

// 9 3 1

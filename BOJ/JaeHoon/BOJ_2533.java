package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2533 {
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean[] isVisit, isEarlyAdaptor;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    isVisit = new boolean[N+1];
    isEarlyAdaptor = new boolean[N+1];
    dp = new int[N+1][2];
    for(int i=0; i<=N; i++)
      graph.add(new ArrayList<>());

    for(int i=0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }
    solve(1);
    System.out.println(Math.min(dp[1][0], dp[1][1]));
  }
  public static void solve(int v) {
    isVisit[v] = true;
    dp[v][0] = 0;
    dp[v][1] = 1;
    for(int next:graph.get(v)) {
      if(!isVisit[next]) {
        solve(next);
        dp[v][0] += dp[next][1];
        dp[v][1] += Math.min(dp[next][1], dp[next][0]);
      }
    }
  }
}

package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22253 {
  static int N;
  static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
  static int[] val;
  static long[][][] dp;
  static boolean[] isVisit;
  static int MOD = 1000000007;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    dp = new long[2][N+1][10];
    for(int i=0; i<=N; i++)
      tree.add(new ArrayList<>());

    val = new int[N+1];
    isVisit = new boolean[N+1];
    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; i++) {
      val[i] = Integer.parseInt(st.nextToken());
    }

    for(int i=0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      tree.get(v1).add(v2);
      tree.get(v2).add(v1);
    }
    for(int i=0; i<2; i++) {
      for(int j=1; j<=N; j++) 
        Arrays.fill(dp[i][j], -1);
    }
    long n1 = dfs(0, 1, 0);
    long n2 = dfs(1, 1, val[1]);
    System.out.println((n1 + n2) % MOD);
  }
  public static long dfs(int onState, int idx, int value) {
    if(dp[onState][idx][value] != -1) return dp[onState][idx][value];
    isVisit[idx] = true;
    dp[onState][idx][value] = 0;
    
    for(int next: tree.get(idx)) {
      if(!isVisit[next]) {
        dp[onState][idx][value] += dfs(0, next, value);
        dp[onState][idx][value] %= MOD;
        if(val[next] >= value) {
          dp[onState][idx][value] += dfs(1, next, val[next]);
          dp[onState][idx][value] %= MOD;
        }
      }
    }
    isVisit[idx] = false;
    dp[onState][idx][value] += onState;
    dp[onState][idx][value] %= MOD;
    return dp[onState][idx][value];
  }
}

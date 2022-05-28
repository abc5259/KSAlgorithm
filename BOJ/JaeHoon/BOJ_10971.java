package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_10971 {
  public static int N;
  public static int[][] w;
  public static boolean[] isUsed;
  public static int min = Integer.MAX_VALUE;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    w = new int[N+1][N+1];
    isUsed = new boolean[N+1];
    for(int i=1; i<=N; i++) {
      for(int j=1; j<=N; j++) {
        w[i][j] = sc.nextInt();
      }  
    }
    isUsed[1] = true;
    dfs(1,1,1,0);
    System.out.println(min);
  }
  public static void dfs(int start, int now, int cnt, int cost) {
    if (now == start && cost > 0) {
			min = Math.min(min, cost);
			return;
		}
    for(int i=1; i<=N; i++) {
      if(w[now][i] > 0) {
        if(i == start && cnt == N) {
          cost += w[now][i];
          dfs(start, i, cnt + 1, cost);
        }
        else if(!isUsed[i]) {
          isUsed[i] = true;
          cost += w[now][i];
          dfs(start, i, cnt + 1, cost);
          cost -= w[now][i];
          isUsed[i] = false;
        }
      }
    }
  }
}

package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
  static int N,M;
  static boolean[] isUsed;
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    isUsed = new boolean[N+1];

    solve(0,"");
    System.out.println(sb);
  }
  public static void solve(int depth,String str) {
    if(depth == M) {
      sb.append(str).append("\n");
      return;
    }

    for(int i=1; i<=N; i++) {
      if(isUsed[i]) continue;
      isUsed[i] = true;
      solve(depth+1,str+i + " ");
      isUsed[i] = false;
    }
  }
}

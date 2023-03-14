package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
  static int N,M;
  static int[] arr;
  static boolean[] isUsed;
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M+1];
    isUsed = new boolean[N+1];

    solve(0);
    System.out.println(sb);
  }
  public static void solve(int depth) {
    if(depth == M) {
      for(int i=0; i<M; i++)
        sb.append(arr[i] + " ");
      sb.append("\n");
      return;
    }

    for(int i=1; i<=N; i++) {
      if(isUsed[i]) continue;
      arr[depth] = i;
      isUsed[i] = true;
      solve(depth+1);
      isUsed[i] = false;
      arr[depth] = 0;
    }
  }
}

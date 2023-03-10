package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {
  static char[][] result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    result = new char[N][N];
    StringBuffer sb = new StringBuffer();
    solve(N,0,N-1,0,N-1,'*');

    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        sb.append(result[i][j]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
  public static void solve(int N, int x1, int x2, int y1, int y2, char c) {
      if(N == 1) {
        result[x1][y1] = c;
        return;
      }
      
      for(int i=0; i<=8; i++) {
        int p = x1 + (i / 3)*N/3;
        int q = p + N/3 - 1;
        int l = y1 + (i % 3)*N/3;
        int r = l + N/3 - 1;
        solve(N/3, p, q, l, r,i == 4 ? ' ' : c);
      }
  }
}

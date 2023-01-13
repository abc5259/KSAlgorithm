package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16507 {
  static int[][] square;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    square = new int[R+1][C+1];
    for(int i=1; i<=R; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=1; j<=C; j++) {
        square[i][j] = square[i][j-1] + square[i-1][j] + Integer.parseInt(st.nextToken()) - square[i-1][j-1];
      }
    }
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<Q; i++) {
      st = new StringTokenizer(br.readLine());
      int r1 = Integer.parseInt(st.nextToken());
      int c1 = Integer.parseInt(st.nextToken());
      int r2 = Integer.parseInt(st.nextToken());
      int c2 = Integer.parseInt(st.nextToken());
      sb.append(solve(r1, c1, r2, c2)).append('\n');
    }
    System.out.println(sb);
  }
  public static int solve(int r1, int c1, int r2, int c2) {
    int sum = square[r2][c2] - square[r2][c1-1] - square[r1-1][c2] + square[r1-1][c1-1];
    int length = (r2 - r1 +1) * (c2 - c1 +1);
    return sum / length;
  }
}

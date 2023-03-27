package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10157 {
  static int[] dx = {-1,0,1,0};
  static int[] dy = {0,1,0,-1};
  static boolean[][] isVisit;
  static int[][] map;
  static int R,C,K;
  static boolean answer;
  static int x,y;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    C = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine());
    map = new int[R][C];
    isVisit = new boolean[R][C];

    dfs(R-1, 0, 0, 0);

    if(answer) System.out.println(y + " " + x);
    else System.out.println(0);
  }
  public static void dfs(int r, int c, int d, int depth) {
    if(depth == R*C) return;
    if(depth+1 == K) {
      answer = true;
      x = R - r;
      y = c + 1;
      return;
    }

    isVisit[r][c] = true;
    map[r][c] = depth+1;

    int nextX = r + dx[d];
    int nextY = c + dy[d];

    if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C || isVisit[nextX][nextY]) {
      d = (d + 1) % 4;
      dfs(r+dx[d], c+dy[d], d,depth+1);
      return;
    }

    dfs(nextX, nextY, d,depth+1);
  }
}

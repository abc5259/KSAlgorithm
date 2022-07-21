package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_1987 {
  static char[][] board;
  static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
  static int result = 1;
  static boolean[] isVisit = new boolean[26];
  static int R;
  static int C;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    board = new char[R][C];
    for(int i=0; i<R; i++) {
      String s = br.readLine();
      for(int j=0; j<C; j++) {
        board[i][j] = s.charAt(j);
      }
    }
    isVisit[board[0][0] - 'A'] = true;
    dfs(0, 0,1);
    System.out.println(result);
  }
  public static void dfs(int row, int col,int sum) {
    result = Math.max(result, sum);
    for(int i=0; i<4; i++) {
      int nx = row + dir[i][0];
      int ny = col + dir[i][1];
      if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
      if(!isVisit[board[nx][ny] - 'A']) {
        isVisit[board[nx][ny] - 'A'] = true;
        dfs(nx, ny,sum+1);
        isVisit[board[nx][ny] - 'A'] = false;
      }
    }
  }
}

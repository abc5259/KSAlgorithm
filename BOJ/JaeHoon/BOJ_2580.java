package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580 {
  static int N = 9;
  static int[][] map = new int[N][N];
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(0, 0);
  }
  public static void dfs(int row , int col) {
    if(col == N) {
      dfs(row+1, 0);
      return;
    }
    if(row == N) {
      //끝
      for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
         sb.append(map[i][j]).append(" ");
        }
        sb.append('\n');
      }
      System.out.println(sb);
      System.exit(0);
      return;
    }
    if(map[row][col] == 0) {
      for(int i=1; i<=9; i++) {
        if(check(row, col, i)) {
          map[row][col] = i;
          dfs(row, col+1);
        }
      }
      map[row][col] = 0;   
      return;
    }
    dfs(row, col+1);
  }

    public static boolean check(int row, int col, int value) {
      // col검사
      for(int i=0; i<N; i++) {
        if(map[row][i] == value)
          return false;
      }
      for(int i=0; i<N; i++) {
        if(map[i][col] == value) 
          return false;
      }

      int startRow = row / 3 * 3;
      int startCol = col / 3 * 3;
      for(int i = startRow; i<startRow+3; i++) {
        for(int j = startCol; j<startCol+3; j++) {
          if(map[i][j] == value) 
            return false;
        }
      }
      return true;
    }
}

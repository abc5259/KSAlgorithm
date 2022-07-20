package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4574 {
  static boolean[][] domino;
  static int[][] sdominoku;
  static int[] dy = {0, 1};
  static int[] dx = {1, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    StringBuffer sb = new StringBuffer();
    int t = 1;
    while(true) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      if(n == 0) break;
      sb.append("Puzzle ").append(t).append('\n');

      sdominoku = new int[9][9];
      domino = new boolean[10][10];

      for(int i=0; i<n; i++) {
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        String pos1 = st.nextToken();
        sdominoku[pos1.charAt(0) - 'A'][pos1.charAt(1) - '1'] = num;

        int num2 = Integer.parseInt(st.nextToken());
        String pos2 = st.nextToken();
        sdominoku[pos2.charAt(0) - 'A'][pos2.charAt(1) - '1'] = num2;

        domino[num][num2] = true;
        domino[num2][num] = true;
      }

      st = new StringTokenizer(br.readLine());
      for(int i=1; i<10; i++) {
        String val = st.nextToken();
        sdominoku[val.charAt(0) - 'A'][val.charAt(1) - '1'] = i;
      }
      dfs(0);
      for(int i=0; i<9; i++) {
        for(int j=0; j<9; j++) {
          sb.append(sdominoku[i][j]);
        }
        sb.append('\n');
      }
      t++;
    }
    System.out.println(sb);
  }
  public static boolean dfs(int pos) {
    if(pos == 81) return true;
    int row = pos / 9;
    int col = pos % 9;
    if(sdominoku[row][col] == 0) {
      for(int k=0; k<2; k++) {
        int nx = row + dx[k];
        int ny = col + dy[k];

        if(nx < 0 || nx>=9 || ny < 0 || ny>=9 || sdominoku[nx][ny] != 0) continue;

        for(int i=1; i<=9; i++) {
          for(int j=1; j<=9; j++) {
            if(i ==j || domino[i][j]) continue;
            if(check(row, col, i) && check(nx, ny, j)) {
              sdominoku[row][col] = i;
              sdominoku[nx][ny] = j;
              domino[i][j] = domino[j][i] = true;
              if(dfs(pos+1)) return true;
              domino[i][j] = domino[j][i] = false;
              sdominoku[nx][ny] = 0;
              sdominoku[row][col] = 0;
            }
          }
        }
      }
    }else {
      return dfs(pos + 1);
    }
    return false;
  }
  public static boolean check(int row, int col, int value) {
    for(int i=0; i<9; i++) {
      if(sdominoku[i][col] == value) return false;
    }
    for(int i=0; i<9; i++) {
      if(sdominoku[row][i] == value) return false;
    }

    int startRow = row /3 *3;
    int startCol = col /3 *3;
    for(int i=startRow; i<startRow+3; i++) {
      for(int j=startCol; j<startCol+3; j++) {
        if(sdominoku[i][j] == value) return false;
      }
    }
    return true;
  }
}

package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2580 {
  static int[][] map;
  static ArrayList<int[]> zeroList = new ArrayList<>();
  static int[] isRowUsed = new int[9];
  static int[] isColUsed = new int[9];
  static int[][] isSquareUsed = new int[3][3];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    map = new int[9][9];
    
    for(int i=0; i<9; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<9; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 0) zeroList.add(new int[]{i,j});
        else {
          isRowUsed[i] |= 1 << map[i][j];
          isColUsed[j] |= 1 << map[i][j];
          isSquareUsed[i/3][j/3] |= 1 << map[i][j];
        }
      }
    }
    StringBuffer sb = new StringBuffer();
    if(zeroList.size() > 0)  {
      solve(0);
    }

    for(int i=0; i<9; i++) {
      for(int j=0; j<9; j++) {
        sb.append(map[i][j] + " ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
  public static boolean solve(int depth) {
    if(depth == zeroList.size()) {
      return true;
    }

    int row = zeroList.get(depth)[0];
    int col = zeroList.get(depth)[1];

    for(int i=1; i<10; i++) {
      if(((isRowUsed[row] >> i) & 1) == 0 && 
         ((isColUsed[col] >> i) & 1) == 0 && 
         ((isSquareUsed[row/3][col/3] >> i) & 1) == 0) {
          
        isRowUsed[row] |= 1 << i;
        isColUsed[col] |= 1 << i;
        isSquareUsed[row/3][col/3] |= 1 << i;
        map[row][col] = i;
        if(solve(depth+1)) return true;
        isRowUsed[row] &= ~(1 << i);
        isColUsed[col] &= ~(1 << i);
        isSquareUsed[row/3][col/3] &= ~(1 << i);
        map[row][col] = 0;
      }
    }

    return false;
  }
}
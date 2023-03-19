package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2580 {
  static int[][] map;
  static ArrayList<int[]> zeroList = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    map = new int[9][9];
    
    for(int i=0; i<9; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<9; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 0) zeroList.add(new int[]{i,j});
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

    boolean[] isUsed = new boolean[10];
    for(int i=0; i<9; i++) {
      if(map[row][i] != 0) isUsed[map[row][i]] = true;
      if(map[i][col] != 0) isUsed[map[i][col]] = true;
    }

    int x = row / 3 * 3;
    int y = col / 3 * 3;

    for(int i=x; i<x+3; i++) {
      for(int j=y; j<y+3; j++) {
        if(map[i][j] != 0) isUsed[map[i][j]] = true;
      }
    }

    for(int i=1; i<10; i++) {
      if(!isUsed[i]) {
        map[row][col] = i;
        if(solve(depth+1)) return true;
        map[row][col] = 0;
      }
    }

    return false;
  }
}
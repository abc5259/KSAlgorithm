package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2210 {
  static int[][] map = new int[5][5];
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};
  static Set<Integer> set = new HashSet<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    for(int i=0; i<5; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<5; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      } 
    }

    for(int i=0; i<5; i++) {
      for(int j=0; j<5; j++) {
        dfs(4,i,j,map[i][j] * 100000);
      } 
    }
    System.out.println(set.size());
  } 

  public static void dfs(int digit, int row, int col, int num) {
    if(digit == -1) {
      set.add(num);
      return;
    }
    
    for(int i=0; i<4; i++) {
      int x = row + dx[i];
      int y = col + dy[i];
      
      if(x < 0 || x >= 5 || y < 0 || y >= 5) continue;
      
      int add = (int)(Math.pow(10, digit) * map[x][y]);
      dfs(digit-1, x, y, num + add);
    }

  }
}

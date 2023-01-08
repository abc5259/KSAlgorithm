package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16173 {
  static int[][] map;
  static int[][] dir = {{0,1},{1,0}};
  static int N;
  static boolean[][] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    isVisit = new boolean[N][N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {  
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(0, 0, 0);
    System.out.println("Hing");
    System.out.println();
  }
  public static void dfs(int depth, int row, int col) {
    
    if(row >= N || col >= N) return;
    if(map[row][col] == -1) {
      System.out.println("HaruHaru");
      System.exit(0);
      return;
    }
    if(map[row][col] == 0) {
      return;
    }
    dfs(depth+1, row+map[row][col], col);
    dfs(depth+1, row, col+map[row][col]);
  }
}

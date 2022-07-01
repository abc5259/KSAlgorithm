package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {
  static int[][] map;
  static boolean[][] isVisit;
  static int[] dx = {0,0,-1,1,1,1,-1,-1};
  static int[] dy = {-1,1,0,0,-1,1,-1,1};
  static int total = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      if(w == 0 && h == 0) break;
      total = 0;
      map = new int[h][w];
      isVisit = new boolean[h][w];
      for(int i=0; i<h; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<w; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      for(int i=0; i<h; i++) {
        for(int j=0; j<w; j++) {
          if(map[i][j] == 1 && !isVisit[i][j]) {
            total++;
            dfs(i, j, w, h);
          }
        }
      }
      sb.append(total).append('\n');
    }
    System.out.print(sb);
  } 
  public static void dfs(int ax, int by,int w, int h) {
    isVisit[ax][by] = true;
    for(int i=0; i<dx.length; i++) {
      int x = ax + dx[i];
      int y = by + dy[i];
      if(x >= 0 && x < h && y >= 0 && y < w) {
        if(map[x][y] == 1 && !isVisit[x][y]) {
          dfs(x,y,w,h);
        }
      }
    }
  }
}

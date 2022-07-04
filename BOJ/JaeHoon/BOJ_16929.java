package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16929 {
  static char[][] map;
  static boolean[][] isVisit;
  static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
  static int N;
  static int M;
  static int count = 0;
  static boolean ok = false;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    isVisit = new boolean[N][M];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        map[i][j] = s.charAt(j);
      }
    }
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        isVisit = new boolean[N][M];
        Point point = new Point(i, j, map[i][j], 0);
        dfs(point, point);
      }
    }
    System.out.println(ok ? "Yes" : "No");
  }
  public static void dfs(Point point,Point startPoint)  {
    isVisit[point.x][point.y] =  true;
    for(int i=0; i<4; i++) {
      int x = point.x + dir[i][0];
      int y = point.y + dir[i][1];
      if(x >=0 && x < N && y >= 0 && y < M) {
        if(!isVisit[x][y] && map[x][y] == point.color) {
          Point p = new Point(x, y, point.color, point.count + 1);
          dfs(p,startPoint);
        }else if(isVisit[x][y] 
                && x == startPoint.x 
                && point.color == startPoint.color
                && y == startPoint.y
                && point.count >= 3) 
        {
          System.out.println("x = " + x + " y = " + y + " cnt = " + point.count);
          ok = true;
          return;
        }
      }
    }
  }
}
class Point {
  int x;
  int y;
  char color;
  int count;
  Point(int x,int y,char color,int count) {
    this.x = x;
    this.y = y;
    this.color = color;
    this.count = count;
  }
}

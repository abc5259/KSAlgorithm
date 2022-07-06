package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
  static int[][] map;
  static char[][] color;
  static char drawColor = 'A';
  static boolean[][] isVisit;
  static int N;
  static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
  static int result = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    color = new char[N][N];
    isVisit = new boolean[N][N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        if(map[i][j] == 1 && !isVisit[i][j]) {
          setColor(new Point(i, j, 0));
          drawColor++;
        }
      }
    }
    isVisit = new boolean[N][N];
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        if(map[i][j] == 1 && !isVisit[i][j]) {
          int cnt = bfs(new Point(i, j, 0));
          isVisit = new boolean[N][N];
          if(cnt == 0) continue;
          result = Math.min(cnt, result);
        }
      }
    }
    System.out.println(result);
  }
  public static int bfs(Point point) {
    Queue<Point> queue = new LinkedList<>();
    queue.offer(point);
    isVisit[point.x][point.y] = true; 
    boolean isZero = false;
    while(!queue.isEmpty()) {
      Point prevP = queue.poll();
      for(int i=0; i<4; i++) {
        int x = prevP.x + dir[i][0];
        int y = prevP.y + dir[i][1];
        Point nextP = new Point(x, y, prevP.count+1);
        if(x >=0 && x < N && y >=0 && y < N) {
          if(!isVisit[x][y]) {
            if(!isZero && map[x][y] == 0) {
              isVisit[x][y] = true;
              queue.offer(nextP);
              isZero = true;
            }
            else if(isZero && map[x][y] == 1 && color[point.x][point.y] != color[x][y]) {
              return prevP.count;
            }
            else if(isZero && map[x][y] == 0) {
              isVisit[x][y] = true;
              queue.offer(nextP);
            }
          }
        }
      }
    }
    return 0;
  }

  public static void setColor(Point point) {
    Queue<Point> queue = new LinkedList<>();
    queue.offer(point);
    isVisit[point.x][point.y] = true; 
    color[point.x][point.y] = drawColor;
    while(!queue.isEmpty()) {
      Point prevP = queue.poll();
      for(int i=0; i<4; i++) {
        int x = prevP.x + dir[i][0];
        int y = prevP.y + dir[i][1];
        Point nextP = new Point(x, y, prevP.count+1);
        if(x >=0 && x < N && y >=0 && y < N) {
          if(!isVisit[x][y] && map[x][y] == 1) {
            color[x][y] = drawColor;
            queue.offer(nextP);
            isVisit[x][y] = true;
          }
        }
      }
    }
  }
  public static class Point {
    int x;
    int y;
    int count;
    Point(int x,int y,int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }
  }
}

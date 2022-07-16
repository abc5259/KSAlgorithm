package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16197 {
  static char[][] map;
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  static boolean[][] isVisit;
  static int N;
  static int M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    isVisit = new boolean[N][M];
    Point[] p = new Point[2];
    int index = 0;
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        map[i][j] = s.charAt(j);
        if(s.charAt(j) == 'o') {
          p[index] = new Point(i, j, 0);
          index++;
        }
      } 
    }
    System.out.println(bfs(p));
  }
  public static int bfs(Point[] start) {
    Queue<Point[]> queue = new LinkedList<>(); 
    queue.offer(start);
    isVisit[start[0].x][start[0].y] = true;
    isVisit[start[1].x][start[1].y] = true;
    while(!queue.isEmpty()) {
      Point[] now = queue.poll();
      if(now[0].cnt >= 10 || now[1].cnt >= 10) return -1;
      for(int i=0; i<4; i++) {
        int ax = now[0].x + dir[i][0];
        int ay = now[0].y + dir[i][1];

        int bx = now[1].x + dir[i][0];
        int by = now[1].y + dir[i][1];
        if((ax < 0 || ax >= N || ay < 0 || ay >= M ) && (bx < 0 || bx >= N || by < 0 || by >= M)) continue;
        
        if((ax < 0 || ax >= N || ay < 0 || ay >= M ) && !(bx < 0 || bx >= N || by < 0 || by >= M)) {
          //1나만 떨어짐 
          return now[0].cnt + 1;
        } 
        if((bx < 0 || bx >= N || by < 0 || by >= M) && !(ax < 0 || ax >= N || ay < 0 || ay >= M )) {
          //1나만 떨어짐 
          return now[1].cnt + 1;
        }
        if(map[ax][ay] == '#') {
          ax -= dir[i][0];
          ay -= dir[i][1];
        }
        if(map[bx][by] == '#') {
          bx -= dir[i][0];
          by -= dir[i][1];
        }
        Point nextA = new Point(ax, ay, now[0].cnt + 1);
        Point nextB = new Point(bx, by, now[1].cnt + 1);
        Point[] nextP = {nextA,nextB};
        queue.offer(nextP);
      }
    }
    return -1;
  }
  static class Point {
    int x;
    int y;
    int cnt;
    Point(int x, int y, int cnt) {
      this.x = x;
      this. y = y;
      this.cnt = cnt;
    }
  }
}

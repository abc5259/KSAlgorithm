package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_3055 {
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  static char[][] map;
  static int N;
  static int M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    ArrayList<Point> water = new ArrayList<>();
    Point D = null;
    Point S = null;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        char c = s.charAt(j);
        map[i][j] = c;
        if(c == 'D') {
          D = new Point(i, j,0,'D');
        }
        else if(c == '*') {
          water.add(new Point(i, j,0,'*'));
        }
        else if(c == 'S') {
          S = new Point(i, j,0,'S');
        }
      }
    }
    int cnt = bfs(D, S, water);
    System.out.println(cnt == -1 ? "KAKTUS" : cnt);
  }
  public static int bfs(Point end, Point start, ArrayList<Point> water) {
    Queue<Point> q = new LinkedList<>();
    for(int i=0; i<water.size(); i++) {
      q.offer(water.get(i));
    }
    q.offer(start);
    while(!q.isEmpty()) {
      Point now = q.poll();
      for(int i=0; i<4; i++) {
        int nextX = now.x + dir[i][0];
        int nextY = now.y + dir[i][1];
        if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
        if(map[nextX][nextY] == 'X') continue;
        if(now.c == '*') {
          if(map[nextX][nextY] == 'D' || map[nextX][nextY] == '*') continue;
          map[nextX][nextY] = '*';
          q.offer(new Point(nextX, nextY, 0, now.c));
        }
        else if(now.c == 'S') {
          if(map[nextX][nextY] == '*' || map[nextX][nextY] == 'S') continue;
          if(map[nextX][nextY] == 'D') return now.cnt+1;
          map[nextX][nextY] = 'S';
          q.offer(new Point(nextX, nextY, now.cnt+1, now.c));
        }
      }
    } 
    return -1;
  }
  static class Point {
    int x;
    int y;
    int cnt;
    char c;
    Point(int x, int y,int cnt, char c) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
      this.c = c;
    }
  }
}

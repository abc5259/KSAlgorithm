package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16948 {
  static int[][] dir = {{-2,-1}, {-2,1},{0,-2},{0,2},{2,-1},{2,1}};
  static int[][] board;
  static boolean[][] isVisit;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    board = new int[N][N];
    isVisit = new boolean[N][N];
    st = new StringTokenizer(br.readLine());
    Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
    Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
    System.out.println(bfs(start, end));
  }
  public static int bfs(Point start, Point end) {
    Queue<Point> q = new LinkedList<>();
    q.offer(start);
    isVisit[start.x][start.y] = true;
    while(!q.isEmpty()) {
      Point now = q.poll();
      if(now.x == end.x && now.y == end.y) return now.cnt;
      for(int i=0; i<6; i++) {
        Point next = new Point(now.x + dir[i][0], now.y + dir[i][1], now.cnt + 1);
        if(next.x < 0 || next.x >= N || next.y < 0 || next.y >= N || isVisit[next.x][next.y]) continue;
        isVisit[next.x][next.y] = true;
        q.offer(next);
      }
    }
    return -1;
  }
  public static class Point {
    int x;
    int y;
    int cnt;
    Point(int x, int y, int cnt) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
    }
  }
}

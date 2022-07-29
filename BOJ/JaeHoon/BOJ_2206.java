package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
  static int[][] map;
  static int[][] dir = {{0,1},{0,-1}, {1,0}, {-1,0}};
  static int[][] isVist;
  static int N;
  static int M;
  static int result = Integer.MAX_VALUE;
  static int sum = 0;
  static int cnt = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());   
    map = new int[N][M];
    isVist = new int[N][M];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        map[i][j] = s.charAt(j) - '0';
        isVist[i][j] = Integer.MAX_VALUE;
      }
    }
    System.out.println(bfs());
  }
  public static int bfs() {
    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(0, 0, 1,0));
    isVist[0][0] = 0;
    while(!q.isEmpty()) {
      Point now = q.poll();
      if(now.x == N-1 && now.y == M-1) return now.cnt;
      for(int i=0; i<4; i++) {
        Point next = new Point(now.x + dir[i][0], now.y + dir[i][1], now.cnt + 1,now.breakWallCnt);
        if(next.x < 0 || next.x >= N || next.y < 0 || next.y >= M) continue;
        if(isVist[next.x][next.y] <= next.breakWallCnt) continue;
        if(map[next.x][next.y] != 1 ) {
          isVist[next.x][next.y] = next.breakWallCnt;
          q.offer(next);
        }
        if(map[next.x][next.y] == 1 && now.breakWallCnt == 0) {
          next.breakWallCnt++;
          isVist[next.x][next.y] = next.breakWallCnt;
          q.offer(next);
        }
      }
    }
    return -1;
  }
  public static class Point{
    int x;
    int y;
    int cnt;
    int breakWallCnt;
    Point(int x, int y, int cnt, int breakWallCnt) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
      this.breakWallCnt = breakWallCnt;
    }

  }
}

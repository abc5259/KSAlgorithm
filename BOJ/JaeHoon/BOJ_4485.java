package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485 {
  static byte[][] map;
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  static int[][] visit;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    StringBuffer sb = new StringBuffer();
    int index = 1;
    while((N = Integer.parseInt(br.readLine())) != 0) {
      map = new byte[N][N];
      visit = new int[N][N];
      for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++) {
          map[i][j] = (byte)Integer.parseInt(st.nextToken());
          visit[i][j] = -1;
        }
      }
      int answer = bfs();
      sb.append("Problem " + index + ": " + answer).append('\n');
      index++;
    }
    System.out.print(sb);
  }
  public static int bfs() {
    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(0, 0, map[0][0]));
    visit[0][0] = map[0][0];
    while(!q.isEmpty()) {
      Point curr = q.poll();
      for(int i=0; i<4; i++) {
        int nextX = curr.x + dir[i][0];
        int nextY = curr.y + dir[i][1];
        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)  continue;
        int nextCnt = curr.cnt + map[nextX][nextY];
        if(visit[nextX][nextY] == -1) {
          visit[nextX][nextY] = nextCnt;
          q.offer(new Point(nextX, nextY, nextCnt));
        }else {
          if(visit[nextX][nextY] <= nextCnt) continue;
          visit[nextX][nextY] = nextCnt;
          q.offer(new Point(nextX, nextY, nextCnt));
        }
      }
    }
    return visit[N-1][N-1];
  }
  static class Point {
    int x,y,cnt;
    Point(int x, int y, int cnt) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
    }
  }
}
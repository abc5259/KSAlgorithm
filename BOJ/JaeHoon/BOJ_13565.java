package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13565 {
  static int[][] map;
  static boolean[][] isVisit;
  static int N,M;
  static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    isVisit = new boolean[N][M];

    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        map[i][j] = s.charAt(j) - '0';
      } 
    }
    for(int col=0; col<M; col++) {
      if(map[0][col] == 0) {
        if(bfs(new Point(0, col))) {
          System.out.println("YES");
          return;
        }
      }
    }
    System.out.println("NO");
  }
  public static boolean bfs(Point start) {
    Queue<Point> q = new LinkedList<>();
    q.offer(start);
    isVisit[start.x][start.y] = true;
    while(!q.isEmpty()) {
      Point curr = q.poll();
      for(int i=0; i<4; i++) {
        int nextX = curr.x + dir[i][0];
        int nextY = curr.y + dir[i][1];
        if(nextX >= N || nextY >= M || nextX < 0 || nextY < 0 || isVisit[nextX][nextY]) continue;
        if(map[nextX][nextY] == 1) continue;
        if(nextX == N-1) return true;
        isVisit[nextX][nextY] = true;
        q.offer(new Point(nextX, nextY));
      }
    }
    return false;
  }
  static class Point {
    int x,y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

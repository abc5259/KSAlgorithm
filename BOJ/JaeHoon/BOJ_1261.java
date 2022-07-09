package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261 {
  static int[][] map;
  static boolean[][] isVisit;
  static int N;
  static int M;
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  static int result = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    map = new int[N+1][M+1];
    isVisit = new boolean[N+1][M+1];
    for(int i=1; i<=N; i++) {
      String s = br.readLine();
      for(int j=1; j<=M; j++) {
        map[i][j] = s.charAt(j-1) - '0';
      }
    }
    System.out.println(bfs(new Point(1, 1, 0)));;
  }
  public static int bfs(Point start) {
    PriorityQueue<Point> q = new PriorityQueue<>();
    q.offer(start);
    isVisit[start.x][start.y] = true;
    while(!q.isEmpty()) {
      Point now = q.poll();
      if(now.x == N && now.y == M) return now.cnt;
      for(int i=0; i<4; i++) {
        int x = now.x + dir[i][0];
        int y = now.y + dir[i][1];
        int cnt = now.cnt;
        if(x <= 0 || x > N || y <= 0 || y > M || isVisit[x][y]) continue;
        if(map[x][y] == 1) cnt++;
        q.offer(new Point(x, y, cnt));
        isVisit[x][y] = true;
      } 
    }
    return 0;
  }
  public static class Point implements Comparable<Point>{
    int x;
    int y;
    int cnt;
    Point(int x,int y, int cnt) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
    }
    @Override
    public int compareTo(Point o) {
      return this.cnt - o.cnt;
    }
  }
}

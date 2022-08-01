package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442 {
  static int N;
  static int M;
  static int K;
  static int[][] map;
  static int[][][] dist;
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  static int answer = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    dist = new int[N][M][K+1];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        map[i][j] = s.charAt(j) - '0';
      }
    }
    System.out.println(bfs(new Point(0, 0, 0)));
  }
  public static int bfs(Point start) {
    Queue<Point> q = new LinkedList<>();
    dist[start.x][start.y][start.breakWallcnt] = 1;
    q.offer(start);
    while(!q.isEmpty()) {
      Point now = q.poll();
      if(now.x == N-1 && now.y == M-1) {
        return dist[N-1][M-1][now.breakWallcnt];
      }
      for(int i=0; i<4; i++) {
        int nextX = now.x + dir[i][0];
        int nextY = now.y + dir[i][1];
        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
        if(map[nextX][nextY] == 0) {
          // 벽이 아닐떄
          if(dist[nextX][nextY][now.breakWallcnt] != 0) continue;
          dist[nextX][nextY][now.breakWallcnt] = dist[now.x][now.y][now.breakWallcnt] + 1;
          q.offer(new Point(nextX, nextY, now.breakWallcnt));
        }else {
          if(now.breakWallcnt + 1 > K) continue;
          if(dist[nextX][nextY][now.breakWallcnt+1] != 0) continue;
          dist[nextX][nextY][now.breakWallcnt+1] = dist[now.x][now.y][now.breakWallcnt] + 1;
          q.offer(new Point(nextX, nextY, now.breakWallcnt+1));
        }
      }
    }
    return -1;
  }
  public static class Point {
    int x;
    int y;
    int breakWallcnt;
    Point(int x, int y,int breakWallcnt) {
      this.x = x;
      this.y = y;
      this.breakWallcnt = breakWallcnt;
    }
  }
}

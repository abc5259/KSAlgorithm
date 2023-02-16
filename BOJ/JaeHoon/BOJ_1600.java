package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
  static int K,W,H;
  static int[][] map;

  static int[] dx = {1,-1,0,0};
  static int[] dy = {0,0,1,-1};
  static int[] jumpDx = {2,2,1,1,-2,-2,-1,-1};
  static int[] jumpDy = {-1,1,-2,2,-1,1,-2,2};
  static int[][][] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    map = new int[H][W];
    for(int i=0; i<H; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<W; j++) {
        map[i][j] =Integer.parseInt(st.nextToken());
      } 
    }

    isVisit = new int[H][W][K+1];
    int answer = bfs();
    System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
  }
  public static int bfs() {
    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(0, 0, K,0));

    for(int i=0; i<H; i++) {
      for(int j=0; j<W; j++) {
        Arrays.fill(isVisit[i][j], Integer.MAX_VALUE);
      }
    }

    isVisit[0][0][K] = 0;

    while(!q.isEmpty()) {
      Point curr = q.poll();

      if(curr.k != 0) {
        for(int i=0; i<8; i++) {
          int nextX = curr.x + jumpDx[i];
          int nextY = curr.y + jumpDy[i];

          if(nextY < 0 || nextY >= W || nextX < 0 || nextX >= H) continue;
          if(isVisit[nextX][nextY][curr.k-1] <= curr.cnt + 1) continue;
          if(map[nextX][nextY] == 1) continue;
          isVisit[nextX][nextY][curr.k-1] = curr.cnt + 1;
          q.offer(new Point(nextX, nextY, curr.k-1, curr.cnt+1));
        }
      }

      for(int i=0; i<4; i++) {
        int nextX = curr.x + dx[i];
        int nextY = curr.y + dy[i];

        if(nextY < 0 || nextY >= W || nextX < 0 || nextX >= H) continue;
        if(isVisit[nextX][nextY][curr.k] <= curr.cnt + 1) continue;
        if(map[nextX][nextY] == 1) continue;
        isVisit[nextX][nextY][curr.k] = curr.cnt + 1;
        q.offer(new Point(nextX, nextY, curr.k, curr.cnt+1));
      }
    }
    int min = Integer.MAX_VALUE;
    for(int k=0; k<=K; k++) {
      min = Math.min(min, isVisit[H-1][W-1][k]);
    }
    return min;
  }
  static class Point {
    int x,y,k,cnt;
    Point(int x, int y, int k, int cnt) {
      this.x = x;
      this.y = y;
      this.k = k;
      this.cnt = cnt;
    }
  }
}

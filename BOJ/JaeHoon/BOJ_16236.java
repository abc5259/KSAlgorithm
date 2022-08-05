package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
  static int N;
  static int[][] map;
  static int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
  static boolean[][] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    int sharkX = 0;
    int sharkY = 0;
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 9) {
          sharkX = i;
          sharkY = j;
          map[i][j] = 0;
        }
      }
    }
    System.out.println(solve(sharkX, sharkY));
  }
  public static int solve(int col, int row) {
    int result = 0;
    int size = 2;
    int cnt = 2;
    Point minP = new Point(col, row, Integer.MAX_VALUE);
    do {
      minP.dist = Integer.MAX_VALUE;
      Queue<Point> q = new LinkedList<>();
      boolean[][] isVisit = new boolean[20][20];
      q.offer(new Point(minP.x, minP.y, 0));
      isVisit[minP.x][minP.y] = true;
      while(!q.isEmpty()) {
        Point curr = q.poll();
        if(curr.dist > minP.dist) break;
        if(map[curr.x][curr.y] > size) continue;
        if(map[curr.x][curr.y] != 0 && map[curr.x][curr.y] < size) {
          if(curr.dist < minP.dist) {
            minP = curr;
          }
          else if(curr.dist == minP.dist) {
            if(curr.x < minP.x) {
              minP = curr;
            }
            else if(curr.x == minP.x && curr.y < minP.y) {
              minP = curr;
            }
          }
          continue;
        }
        for(int i=0; i<4; i++) {
          int nextX = curr.x + dir[i][0];
          int nextY = curr.y + dir[i][1];
          if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || isVisit[nextX][nextY]) continue;
          isVisit[nextX][nextY] = true;
          q.offer(new Point(nextX, nextY, curr.dist + 1));
        }
      }

      if(minP.dist != Integer.MAX_VALUE) {
        result += minP.dist;
        cnt--;
        if(cnt == 0) {
          size++;
          cnt = size;
        }
        map[minP.x][minP.y] = 0;
      }
    }while(minP.dist != Integer.MAX_VALUE);
    return result;
  }

  public static class Point {
    int x,y,dist;
    Point(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }
  }


}

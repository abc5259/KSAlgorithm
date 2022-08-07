package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6087 {
  static int W,H;
  static char[][] map;
  static ArrayList<int[]> C = new ArrayList<>();
  static int[][] visit;
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    map = new char[H][W];
    visit = new int[H][W];
    for(int i=0; i<H; i++) {
      String s = br.readLine();
      for(int j=0; j<W; j++) {
        map[i][j] = s.charAt(j);
        visit[i][j] = Integer.MAX_VALUE;
        if(map[i][j] == 'C') {
          C.add(new int[]{i,j});
        }
      }
    }
    System.out.println(bfs());
  }

  public static int bfs() {
    int[] startPoint = C.get(0);
    int[] endPoint = C.get(1);
    PriorityQueue<Point> q = new PriorityQueue<>();
    q.offer(new Point(startPoint[0], startPoint[1], -1, 0));
    visit[startPoint[0]][startPoint[1]] = 0;
    while(!q.isEmpty()) {
      Point curr = q.poll();
      if(curr.x == endPoint[0] && curr.y == endPoint[1]) {
        return curr.mirrorCnt;
      }
      for(int i=0; i<4; i++) {
        int nextX = curr.x + dir[i][0];
        int nextY = curr.y + dir[i][1];
        if(nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) continue;
        //벽이라면 못감
        if(map[nextX][nextY] == '*') continue;
        //초기 상태이거나 방향이 같다면
        if(curr.direction == -1 || curr.direction == i) {
          if(visit[nextX][nextY] >= curr.mirrorCnt) {
            visit[nextX][nextY] = curr.mirrorCnt;
            q.offer(new Point(nextX, nextY, i, curr.mirrorCnt));
          }
        }else {
          //방향이 다르다면
          if(visit[nextX][nextY] >= curr.mirrorCnt+1) {
            visit[nextX][nextY] = curr.mirrorCnt+1;
            q.offer(new Point(nextX, nextY, i, curr.mirrorCnt+1));
          }

        }
      }
    }
    return -1;
  }

  public static class Point implements Comparable<Point>{
    int x,y,direction,mirrorCnt;
    Point(int x, int y, int direction, int mirrorCnt) {
      this.x = x;
      this.y = y;
      this.direction = direction;
      this.mirrorCnt = mirrorCnt;
    }
    @Override
    public int compareTo(Point o) {
      return this.mirrorCnt - o.mirrorCnt;
    }
  }
}
package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1981 {
  static int[][] board;
  static int N;
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  static int minNum = Integer.MAX_VALUE;
  static int maxNum = Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    board = new int[N][N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        minNum = Math.min(minNum, board[i][j]);
        maxNum = Math.max(maxNum, board[i][j]);
      }
    }
    int low = -1;
    int high = maxNum - minNum;
    while(low + 1 < high) {
      int mid = (low + high) / 2;
      if(check(mid)) {
        high = mid;
      }else {
        low = mid;
      }
    }
    System.out.println(high);
  }
  static public boolean check(int dif) {
    for(int k=minNum; k+dif <= maxNum; k++) {
      int s = k;
      int b = k + dif;

      if(s > board[0][0] || board[0][0] > b) continue;

      boolean[][] isVisit = new boolean[N][N];
      Queue<Point> q = new LinkedList<>();
      q.offer(new Point(0, 0));
      isVisit[0][0] = true;

      while(!q.isEmpty()) {
        Point curr = q.poll();
        if(curr.x == N - 1 && curr.y == N - 1) return true;
        for(int i=0; i<4; i++) {
          int nexX = curr.x + dir[i][0];
          int nexY = curr.y + dir[i][1];
          if(nexX < 0 || nexX >= N || nexY < 0 || nexY >= N) continue;
          if(!isVisit[nexX][nexY] && s <= board[nexX][nexY] && board[nexX][nexY] <= b) {
            isVisit[nexX][nexY] = true;
            q.offer(new Point(nexX, nexY));
          }
        }
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

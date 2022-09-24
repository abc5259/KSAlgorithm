package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086 {
  static int[][] board;
  static boolean[][] isVisit;
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,1},{1,-1}};
  static int N,M;
  static Queue<Point> q = new LinkedList<>();
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    isVisit = new boolean[N][M];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if(board[i][j] == 1) {
          q.offer(new Point(i, j, 0));
          isVisit[i][j] = true;
        }
      }
    }
    bfs();
    System.out.println(answer);
  }
  static public void bfs() {
    while(!q.isEmpty()) {
      Point curr = q.poll();
      answer = Math.max(answer, curr.cnt);
      for(int i=0; i<8; i++) {
        int nextX = curr.x + dir[i][0];
        int nextY = curr.y + dir[i][1];
        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || isVisit[nextX][nextY]) continue;
        isVisit[nextX][nextY] = true;
        q.offer(new Point(nextX, nextY, curr.cnt + 1));
      }
    }
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

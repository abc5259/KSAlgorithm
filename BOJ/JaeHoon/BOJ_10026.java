package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
  static char[][] map;
  static boolean[][] isVisit;
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  static int N;
  static int people1 = 0;
  static int people2 = 0;
  public static void main(String[] args) throws IOException {
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   N = Integer.parseInt(br.readLine());
   map = new char[N][N];
   isVisit = new boolean[N][N];
   for(int i=0; i<N; i++) {
    String s = br.readLine();
    for(int j=0; j<N; j++){
      map[i][j] = s.charAt(j);
    }
   }
   for(int i=0; i<N; i++) {
    for(int j=0; j<N; j++) {
      if(!isVisit[i][j]) {
        int cnt = bfs(i, j);
        people1++;
      }
    }
   }

   isVisit = new boolean[N][N];

   for(int i=0; i<N; i++) {
    for(int j=0; j<N; j++) {
      if(!isVisit[i][j]) {
        int cnt = bfs2(i, j);
        people2++;
      }
    }
   }
   System.out.println(people1 + " " + people2);
  }
  public static int bfs(int row, int col) {
    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(row, col));
    isVisit[row][col] = true;
    char color = map[row][col];
    int cnt = 1;
    while(!q.isEmpty()) {
      Point curr = q.poll();
      for(int i=0; i<4; i++) {
        int nextRow = curr.row + dir[i][0];
        int nextCol = curr.col + dir[i][1];
        if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N || isVisit[nextRow][nextCol]) continue;
        // 다른 색깔인 경우 
        if(color != map[nextRow][nextCol]) continue;
        isVisit[nextRow][nextCol] = true;
        cnt++;
        q.offer(new Point(nextRow, nextCol));
      }
    }
    return cnt;
  }

  public static int bfs2(int row, int col) {
    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(row, col));
    isVisit[row][col] = true;
    char color = map[row][col];
    int cnt = 1;
    while(!q.isEmpty()) {
      Point curr = q.poll();
      for(int i=0; i<4; i++) {
        int nextRow = curr.row + dir[i][0];
        int nextCol = curr.col + dir[i][1];
        if(nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N || isVisit[nextRow][nextCol]) continue;
        // 빨강인 경우
        if(color == 'B' && color != map[nextRow][nextCol]) continue;
        if((color == 'R' || color == 'G') && map[nextRow][nextCol] == 'B') continue;
        isVisit[nextRow][nextCol] = true;
        cnt++;
        q.offer(new Point(nextRow, nextCol));
      }
    }
    return cnt;
  }

  public static class Point {
    int row, col;
    Point(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}

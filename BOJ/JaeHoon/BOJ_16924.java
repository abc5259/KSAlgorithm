package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16924 {
  static char[][] board;
  static int N,M;
  static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
  static StringBuffer sb = new StringBuffer();
  static ArrayList<Point> points = new ArrayList<>();
  static int total = 0;
  static ArrayList<int[]> arr = new ArrayList<>();
  static int[][] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new char[N][M];
    isVisit = new int[N][M];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        board[i][j] = s.charAt(j);
      }
    }

    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(board[i][j] == '*') bfs(i, j);
      }
    }

    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(board[i][j] == '*' && isVisit[i][j] == 0) {
          System.out.println(-1);
          return;
        }
      }
    }
    sb.append(total).append('\n');
    for(Point p: points) {
      sb.append(p.x + " " + p.y + " " + p.s).append('\n');
    }
    System.out.println(sb);
  }
  static public boolean scope(int x, int y) {
    if(x < 0 || y < 0 || x >= N || y >= M) {
      return false;
    }
    if(board[x][y] == '.') return false;
    return true;
  }
  static public void bfs(int row, int col) {
    int size = 0;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{row,col});
    while(!q.isEmpty()) {
      if(q.size() == 1) {
        int[] curr = q.poll();
        int x1 = curr[0] + dir[0][0];
        int y1 = curr[1] + dir[0][1];

        int x2 = curr[0] + dir[1][0];
        int y2 = curr[1] + dir[1][1];

        int x3 = curr[0] + dir[2][0];
        int y3 = curr[1] + dir[2][1];

        int x4 = curr[0] + dir[3][0];
        int y4 = curr[1] + dir[3][1];

        if(scope(x1, y1) && scope(x2, y2) && scope(x3, y3) && scope(x4, y4)) {
          isVisit[curr[0]][curr[1]] = 1;
          isVisit[x1][y1] = 1;
          isVisit[x2][y2] = 1;
          isVisit[x3][y3] = 1;
          isVisit[x4][y4] = 1;
          q.offer(new int[]{x1,y1});
          q.offer(new int[]{x2,y2});
          q.offer(new int[]{x3,y3});
          q.offer(new int[]{x4,y4});
          size++;
        }

      }else {
        int[] curr1 = q.poll();
        int[] curr2 = q.poll();
        int[] curr3 = q.poll();
        int[] curr4 = q.poll();

        int x1 = curr1[0] + dir[0][0];
        int y1 = curr1[1] + dir[0][1];

        int x2 = curr2[0] + dir[1][0];
        int y2 = curr2[1] + dir[1][1];

        int x3 = curr3[0] + dir[2][0];
        int y3 = curr3[1] + dir[2][1];

        int x4 = curr4[0] + dir[3][0];
        int y4 = curr4[1] + dir[3][1];

        if(scope(x1, y1) && scope(x2, y2) && scope(x3, y3) && scope(x4, y4)) {
          isVisit[x1][y1] = 1;
          isVisit[x2][y2] = 1;
          isVisit[x3][y3] = 1;
          isVisit[x4][y4] = 1;
          q.offer(new int[]{x1,y1});
          q.offer(new int[]{x2,y2});
          q.offer(new int[]{x3,y3});
          q.offer(new int[]{x4,y4});
          size++;
        }
      }
    }
    if(size > 0) {
      for(int i=size; i>0; i--) {
        points.add(new Point(row+1, col+1, i));
        total++;
      }
    }
  }
  static class Point {
    int x,y,s;
    Point(int x, int y, int s) {
      this.x = x;
      this.y = y;
      this.s = s;
    }
  }
}
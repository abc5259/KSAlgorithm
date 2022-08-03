package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16954 {
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1},{0,0}};
  static char[][] board = new char[8][8];
  static ArrayList<Dot> walls = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int i=0; i<8; i++) {
      String s = br.readLine();
      for(int j=0; j<8; j++) {
        char c = s.charAt(j);
        board[i][j] = c;
      }
    }
    System.out.println(bfs(new Point(7, 0)) ? 1 : 0);
  }
  public static boolean bfs(Point start) {
    Queue<Point> q = new LinkedList<>();
    q.offer(start);
    while(!q.isEmpty()) {
      int size = q.size();
      for(int k=0; k<size; k++) {
        Point now = q.poll();
        if(now.x == 0 && now.y == 7) return true;
        if(board[now.x][now.y] == '#') continue;
        for(int i=0; i<9; i++) {
          int nextX = now.x + dir[i][0];
          int nextY = now.y + dir[i][1];
          if(nextX < 0 || nextY < 0 || nextX >= 8 || nextY >= 8) continue;
          if(board[nextX][nextY] == '#') continue;
          q.offer(new Point(nextX, nextY ));
        }
      }
      downWall();
    }
    return false;
  }
  public static void downWall() {
    for(int i=7; i>=1; i--) {
      for(int j=0; j<=7; j++) {
        if(board[i][j] == '#') {
          if(i+1 >= 8) {
            board[i][j] = '.';
          }else {
            board[i][j] = '.';
            board[i+1][j] = '#';
          }
        }
      }
    }
  }
  public static boolean check(int row, int col, ArrayList<Dot> walls) {
    for(int i=0; i<walls.size(); i++) {
      if(walls.get(i).x == row && walls.get(i).y == col) return false;
    }
    return true;
  }
  public static class Dot {
    int x,y;
    Dot(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  public static class Point {
    int x,y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17265 {
  static char[][] map;
  static int N;
  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;
  static int[] dx = {0,1};
  static int[] dy = {1,0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    map = new char[N][N];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        map[i][j] = st.nextToken().charAt(0);
      }
    }

    bfs();
    System.out.println(max + " " + min);
  }
  public static void bfs() {
    Queue<Point> q = new LinkedList<>();
    Point start = new Point(0, 0, map[0][0] - '0', true);
    start.isVisit[0][0] = true;
    q.offer(start);

    while(!q.isEmpty()) {
      Point curr = q.poll();
      if(curr.x == N-1 && curr.y == N-1) {
        min = Math.min(min, curr.total);
        max = Math.max(max, curr.total);
      }
      for(int i=0; i<2; i++) {
        int x = curr.x + dx[i];
        int y = curr.y + dy[i];
        if(x < 0 || x >= N || y < 0 || y >= N || curr.isVisit[x][y]) continue;
        boolean[][] isVisit = curr.isVisit.clone();    
        for(int j=0; j<N; j++)
          isVisit[j] = curr.isVisit[j].clone();
        
        isVisit[x][y] = true;
        Point next;
        if( '0' <= map[x][y] && map[x][y] <= '5') {
          int total = curr.calc(curr.total,map[x][y] - '0');
          next = new Point(x, y, total, true);
          next.isVisit = isVisit;
        }else {
          next = new Point(x, y, curr.total, false);
          next.operate = map[x][y];
          next.isVisit = isVisit;
        }
        q.offer(next);
      }
    }
  }
  static class Point {
    boolean isNum;
    int x,y,total;
    char operate;
    boolean[][] isVisit = new boolean[N][N];
    Point(int x, int y, int total, boolean isNum) {
      this.x = x;
      this.y = y;
      this.total = total;
      this.isNum = isNum;
    }
    public int calc(int total,int num) {
      switch(operate) {
        case '+': 
          return total + num;
        case '-': 
          return total - num;
        case '*': 
          return total * num;
        }
        return -1;
      }
    public void sum(int num) {
      total += num;
    }
    public void minus(int num) {
      total -= num;
    }
    public void mulit(int num) {
      total *= num;
    }
  }
}

package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {
  static int N,M;
  static char[][] map;
  static boolean[][] isVisitMen;
  static int[] dx = {1,-1,0,0};
  static int[] dy = {0,0,-1,1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    StringBuffer sb = new StringBuffer();

    for(int t=0; t<T; t++) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());

      map = new char[N][M];
      int startX = 0;
      int startY = 0;
      Queue<Point> menQ = new LinkedList<>();
      Queue<Point> fireQ = new LinkedList<>();
      isVisitMen = new boolean[N][M];
      for(int i=0; i<N; i++) {
        String s = br.readLine();
        for(int j=0; j<M; j++) {
          map[i][j] = s.charAt(j);
          if(map[i][j] == '@') { //상근이
            menQ.offer(new Point(i, j, 0));
            isVisitMen[startX][startY] = true;
          } 
          else if(map[i][j] == '*'){  // 불
            fireQ.offer(new Point(i, j));
          }
        } 
      }

      int answer = bfs(menQ, fireQ);
      sb.append(answer == -1 ? "IMPOSSIBLE" : answer).append('\n');
    }
    System.out.println(sb);
  }
  public static int bfs(Queue<Point> menQ, Queue<Point> fireQ) {
    while(!menQ.isEmpty()) {

      // 불 동서남북으로 옮겨붙기 
      int fireQSize = fireQ.size();
      for(int i=0; i<fireQSize; i++) {
        Point fire = fireQ.poll();

        for(int d=0; d<4; d++) {
          int nextX = fire.x + dx[d];
          int nextY = fire.y + dy[d];
          if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextX][nextY] == '*' || map[nextX][nextY] == '#') continue;
          map[nextX][nextY] = '*';
          fireQ.offer(new Point(nextX, nextY));
        }
      }
      
      // 상근이 이동 
      int menQSize = menQ.size();
      for(int i=0; i<menQSize; i++) {
        Point curr = menQ.poll();

        for(int d=0; d<4; d++) {
          int nextX = curr.x + dx[d];
          int nextY = curr.y + dy[d];
  
          if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
            return curr.cnt+1;
          }
          
          if(map[nextX][nextY] == '*' || map[nextX][nextY] == '#' || isVisitMen[nextX][nextY]) continue;
  
          isVisitMen[nextX][nextY] = true;
          menQ.offer(new Point(nextX, nextY,curr.cnt+1));
        }
      }
    }
    return -1;
  }
  static class Point {
    int x,y,cnt;
    Point(int x, int y, int cnt) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
    }
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

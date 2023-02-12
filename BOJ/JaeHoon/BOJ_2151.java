package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2151 {
  static int N;
  static char[][] home;
  static int answer = Integer.MAX_VALUE;
  static int[][][] visit;
  static int[] end;
  static int[] dx = {-1,1,0,0}; //상 하 좌 우 
  static int[] dy = {0,0,-1,1};

  static class Point {
    int x,y,mirrorCnt,dir;
    Point(int x, int y, int mirrorCnt, int dir) {
      this.x = x;
      this.y = y;
      this.mirrorCnt = mirrorCnt;
      this.dir = dir;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    home = new char[N][N];
    visit = new int[N][N][4];
    int[] start = null;
    for(int i=0; i<N; i++) {
      String s = br.readLine();
     for(int j=0; j<N; j++) {
        home[i][j] = s.charAt(j);
        if(home[i][j] == '#' && start == null) {
          start = new int[]{i,j};
        }
        if(home[i][j] == '#' && start != null) {
          end = new int[]{i,j};
        }
      } 
    }

    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        Arrays.fill(visit[i][j], Integer.MAX_VALUE);
      } 
    }
  
    bfs(start);
    System.out.println(answer);
  }
  public static void bfs(int[] start) {
    Queue<Point> q = new LinkedList<>();

    for(int i=0; i<4; i++) {
      visit[start[0]][start[1]][i] = 0;
      q.offer(new Point(start[0], start[1], 0, i));
    }

    while(!q.isEmpty()) {
      Point curr = q.poll();
      
      int nextX = curr.x + dx[curr.dir];
      int nextY = curr.y + dy[curr.dir];
      
      if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || home[nextX][nextY] == '*') continue;
      if(nextX == end[0] && nextY == end[1]) { //거울찾음
        answer = Math.min(answer, curr.mirrorCnt); // 정답 최솟값으로 갱신 
      }

      if(home[nextX][nextY] == '.') {

        if(visit[nextX][nextY][curr.dir] > curr.mirrorCnt) {
          visit[nextX][nextY][curr.dir] = curr.mirrorCnt;
          q.offer(new Point(nextX, nextY, curr.mirrorCnt, curr.dir));
        }
      }
      else if(home[nextX][nextY] == '!') {
        if(visit[nextX][nextY][curr.dir] > curr.mirrorCnt) {
          visit[nextX][nextY][curr.dir] = curr.mirrorCnt;
          q.offer(new Point(nextX, nextY, curr.mirrorCnt, curr.dir));
        }

        int dir1 = 0,dir2 = 1;
        if(curr.dir == 0 || curr.dir == 1) {
          dir1 = 2;
          dir2 = 3;
        }

        if(visit[nextX][nextY][dir1] > curr.mirrorCnt + 1) {
          visit[nextX][nextY][dir1] = curr.mirrorCnt + 1;
          q.offer(new Point(nextX, nextY, curr.mirrorCnt+1, dir1));
        }

        if(visit[nextX][nextY][dir2] > curr.mirrorCnt + 1) {
          visit[nextX][nextY][dir2] = curr.mirrorCnt + 1;
          q.offer(new Point(nextX, nextY, curr.mirrorCnt+1, dir2));
        }
      }
    }
  }
  
  
}

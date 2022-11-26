package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593 {
  static char[][][] buliding;
  static boolean[][][] isVisit;
  static int[] start,end;
  static int[][] dir = {{0,1,0},{0,-1,0},{0,0,1},{0,0,-1},{1,0,0},{-1,0,0}};
  static int L,R,C;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      L = Integer.parseInt(st.nextToken());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      if(L == 0 && R == 0 && C == 0) break;
      buliding = new char[L][R][C];
      isVisit = new boolean[L][R][C];
      for(int i=0; i<L; i++) {
        for(int row=0; row<R; row++) {
          String s = br.readLine();
          for(int col=0; col<C; col++) {
            buliding[i][row][col] = s.charAt(col);
            if(buliding[i][row][col] == 'S') start = new int[]{row,col,i};
            if(buliding[i][row][col] == 'E') end = new int[]{row,col,i};
          }
        }
        if(i != L-1)
          br.readLine();
      }
      int answer = bfs();
      if(answer != -1) sb.append("Escaped in " + answer + " minute(s).\n");
      else sb.append("Trapped!\n");
      br.readLine();
    }
    System.out.println(sb);
  }
  public static int bfs() {
    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(start[0],start[1],start[2],0));
    isVisit[start[2]][start[0]][start[1]] = true;
    while(!q.isEmpty()) {
      Point curr = q.poll();
      for(int i=0; i<6; i++) {
        int nextX = curr.x + dir[i][1];
        int nextY = curr.y + dir[i][2];
        int nextZ = curr.z + dir[i][0];
        if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C || nextZ < 0 || nextZ >= L) continue;
        if(isVisit[nextZ][nextX][nextY]) continue;
        if(buliding[nextZ][nextX][nextY] == '#') continue;
        // System.out.println("z = " + nextZ + " x = " + nextX + " y = " + nextY);
        if(nextX == end[0] && nextY == end[1] && nextZ == end[2]) {
          return curr.time + 1;
        }
        q.offer(new Point(nextX, nextY, nextZ, curr.time+1));
        isVisit[nextZ][nextX][nextY] = true;
      }
    }
    return -1;
  }
  static class Point {
    int x,y,z,time;
    Point(int x, int y,int z,int time) {
      this.x = x;
      this.y = y;
      this.z = z;
      this.time = time;
    }
  }
}

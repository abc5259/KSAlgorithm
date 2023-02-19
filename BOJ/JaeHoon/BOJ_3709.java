package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3709 {
  static int[][] map;
  static int N;
  static int[] dx = {-1,1,0,0}; // 상 하 좌 우
  static int[] dy = {0,0,-1,1}; 
  static boolean[][][] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    StringBuffer sb = new StringBuffer();

    for(int t=0; t<T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      int R = Integer.parseInt(st.nextToken());

      map = new int[N+1][N+1];

      for(int i=0; i<R; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map[x][y] = 1;
      }
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      isVisit = new boolean[N+1][N+1][4];
      int[] answer = solve(x, y);
      sb.append(answer[0] + " " + answer[1]+"\n");
    }
    System.out.println(sb);
  }
  public static int[] solve(int startX, int startY) {

    Queue<int[]> q = new LinkedList<>();
    for(int i=0; i<4; i++) {
      int x = startX + dx[i];
      int y = startY + dy[i];
      if(x <= 0 || x >= N+1 || y <= 0 || y >= N+1) continue;
      q.offer(new int[]{x,y,i});
      isVisit[x][y][i] = true;
    }

    while(!q.isEmpty()) {
      int[] curr = q.poll();

      if(map[curr[0]][curr[1]] == 0) { //거울이 없으면 
        int nextX = curr[0] + dx[curr[2]];
        int nextY = curr[1] + dy[curr[2]];
        if(nextX <= 0 || nextY <=0 || nextX >= N+1 || nextY >= N+1) {
          return new int[]{nextX,nextY};
        }
        if(isVisit[nextX][nextY][curr[2]]) break;
        q.offer(new int[]{nextX,nextY,curr[2]});
      }else { //거울이 있으면
        int dir = curr[2];
        if(dir == 0) {
          dir = 3;
        }
        else if(dir == 1) {
          dir = 2;
        }
        else if(dir == 2) {
          dir = 0;
        }
        else if(dir == 3) {
          dir = 1;
        }

        int nextX = curr[0] + dx[dir];
        int nextY = curr[1] + dy[dir];
        if(nextX <= 0 || nextY <=0 || nextX >= N+1 || nextY >= N+1) {
          return new int[]{nextX,nextY};
        }
        if(isVisit[nextX][nextY][dir]) break;
        q.offer(new int[]{nextX,nextY,dir});

      }
    }

    return new int[]{0,0};
  }
}

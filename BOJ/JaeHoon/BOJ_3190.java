package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190 {
  static class Go {
    int t;
    char d;
    public Go(int t, char d) {
      this.t = t;
      this.d = d;
    }
  }
  static int N;
  static int[][] map;
  static int[][] dir = { //상하좌우 
    {-1,0,2,3},
    {1,0,3,2},
    {0,-1,1,0},
    {0,1,0,1}
  };
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    int K = Integer.parseInt(br.readLine());
    for(int i=0; i<K; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      map[x][y] = 1; // 사과는 1 
    }
    int L = Integer.parseInt(br.readLine());
    Go[] gos = new Go[L];
    for(int i=0; i<L; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      char d = st.nextToken().charAt(0);
      gos[i] = new Go(t, d);
    }

    int curT = 0;
    int curD = 3; 
    int[] curPos = {0,0};
    Queue<int[]> snake = new ArrayDeque<>();
    snake.add(new int[]{0,0});
    int gosIdx = 0;
    while (true) {
      int nx = curPos[0];
      int ny = curPos[1];
      if(gosIdx < L && curT == gos[gosIdx].t) {
        if(gos[gosIdx].d == 'L') {
          curD = dir[curD][2];
        }else {
          curD = dir[curD][3];
        }
        gosIdx++;
      }
      nx += dir[curD][0];
      ny += dir[curD][1];
      curT++;
      // System.out.println("time = "+ curT + " nx = " + nx + " ny = " + ny);

      if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 2) {
        System.out.println(curT);
        return;
      }

      snake.add(new int[]{nx,ny});
      if(map[nx][ny] != 1) {
        int[] tail = snake.poll();
        map[tail[0]][tail[1]] = 0; // 꼬리지움 
      }
      curPos[0] = nx;
      curPos[1] = ny;
      map[nx][ny] = 2;
      // for(int i=0; i<N; i++) {
      //   System.out.println(Arrays.toString(map[i]));
      // }
      // System.out.println();
    }
  }
}

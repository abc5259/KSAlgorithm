package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238 {
  static int N,M;
  static int fuel;
  static int[][] map;
  static int[] dx = {0,0,-1,1};
  static int[] dy = {1,-1,0,0};
  static boolean[] success;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    fuel = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    success = new boolean[M];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    int[] start = new int[2];
    start[0] = Integer.parseInt(st.nextToken()) -1;
    start[1] = Integer.parseInt(st.nextToken()) -1;

    int[][] arr = new int[M][4];
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken()) -1;
      arr[i][1] = Integer.parseInt(st.nextToken()) -1;
      arr[i][2] = Integer.parseInt(st.nextToken()) -1;
      arr[i][3] = Integer.parseInt(st.nextToken()) -1;
    }
    int cnt = 0;
    while (cnt != M) {
      int destIndex = -1;
      int minD = Integer.MAX_VALUE;
      for(int i=0; i<M; i++) {
        if(success[i]) continue;
        int curD = dist(start, new int[]{arr[i][0], arr[i][1]});
        if(curD == -1) {
          System.out.println(-1);
          return;
        }
        if(minD > curD) {
          minD = curD;
          destIndex = i;
        }
        else if(minD == curD) {
          if(arr[destIndex][0] > arr[i][0]) {
            minD = curD;
            destIndex = i;
          }
          else if(arr[destIndex][0] == arr[i][0]) {
            if(arr[destIndex][1] > arr[i][1]) {
              minD = curD;
              destIndex = i;
            }
          }
        }
      }
    
      if(fuel < minD) {
        System.out.println(-1);
        return;
      }

      fuel -= minD;
      start[0] = arr[destIndex][0];
      start[1] = arr[destIndex][1];
      int dd = dist(start, new int[]{arr[destIndex][2], arr[destIndex][3]});
      if(fuel < dd) {
        System.out.println(-1);
        return;
      }
      fuel = fuel - dd + dd*2;
      start[0] = arr[destIndex][2];
      start[1] = arr[destIndex][3];
      success[destIndex] = true;
      cnt++;
    }

    System.out.println(fuel);
  }

  public static int dist(int[] source, int[] dest) {
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{source[0], source[1], 0});
    boolean[][] visited = new boolean[N][N];
    visited[source[0]][source[1]] = true;
    while (!q.isEmpty()) {
      int[] curr = q.poll();
      if(curr[0] == dest[0] && curr[1] == dest[1]) {
        return curr[2];
      }
      for(int i=0; i<4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];

        if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == 1) continue;
        visited[nx][ny] = true;
        q.offer(new int[]{nx,ny,curr[2] + 1});
      }
    }

    return -1;
  }
}

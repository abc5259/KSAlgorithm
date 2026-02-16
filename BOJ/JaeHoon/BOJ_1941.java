package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BOJ_1941 {
  static char[][] map;
  static int N = 5;
  static int result;
  static int[] dx = {0,0,-1,1};
  static int[] dy = {1,-1,0,0};
  static boolean[][] visited;
  static int[] selected;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    map = new char[N][N];
    visited = new boolean[N][N];
    selected = new int[7];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<N; j++) {
        map[i][j] = s.charAt(j);
      }
    }
    solve(0, 0, 0);
    System.out.println(result);
  }
  public static void solve(int depth, int start, int ySum) {
    if(depth == 7) {
      bfs();
      return;
    }

    for(int i=start; i<25; i++) {
      int x = i / 5;
      int y = i % 5;
      if(ySum == 3 && map[x][y] == 'Y') continue;
      
      selected[depth] = i;
      solve(depth+1, i+1, map[x][y] == 'Y' ? ySum + 1 : ySum);
    }
  }

  public static void bfs() {
    Queue<int[]> q = new ArrayDeque<>();
    boolean[] visited = new boolean[25];
    q.offer(new int[]{selected[0]/5,selected[0]%5});
    visited[selected[0]] = true;
    int connect = 1;

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for(int d=0; d<4; d++) {
        int nx = cur[0] + dx[d];
        int ny = cur[1] + dy[d];
        int nc = nx*5 + ny;

        if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nc]) continue;

        for(int i=0; i<7; i++) {
          if(visited[selected[i]]) continue;
          if(selected[i] == nc) {
            connect++;
            visited[selected[i]] = true;
            q.offer(new int[]{nx,ny});
          }
        }
      }
    }

    if(connect == 7) result++;
  }
}

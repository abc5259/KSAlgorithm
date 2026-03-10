package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {
  static char[][] map;
  static int N,M;
  static int[][][] dp;
  static boolean[][][] visited;
  static int[] dx = {0,0,-1,1};
  static int[] dy = {1,-1,0,0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    dp = new int[N][M][1<<6+1];
    visited = new boolean[N][M][1<<6+1];
    List<int[]> door = new ArrayList<>();
    int[] start = new int[2];
    for(int i=0; i<N; i++) {
      String s = br.readLine();
      for(int j=0; j<M; j++) {
        map[i][j] = s.charAt(j);
        if(map[i][j] == '1') {door.add(new int[]{i,j});}
        if(map[i][j] == '0') {
          start[0] = i;
          start[1] = j;
        }
      }
    }

    System.out.println(bfs(start[0], start[1]));
  }

  public static int bfs(int x, int y) {
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{x,y,0,0});
    visited[x][y][0] = true;
    while (!q.isEmpty()) {
      int[] curr = q.poll();

      if(map[curr[0]][curr[1]] == '1') {
        return curr[3];
      }

      for(int i=0; i<4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];
        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
        if(map[nx][ny] == '#') continue;
        if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
          if((curr[2] & (1 << (map[nx][ny] - 'A'))) > 0) {
            if(visited[nx][ny][curr[2]]) continue;
            visited[nx][ny][curr[2]] = true;
            q.offer(new int[]{nx,ny,curr[2],curr[3]+1});
          }
        }
        else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
          int key2 = (curr[2] | (1 << (map[nx][ny] - 'a')));
          if(visited[nx][ny][key2]) continue;
          visited[nx][ny][key2] = true;
          q.offer(new int[]{nx, ny, key2, curr[3]+1});
        }else {
          if(visited[nx][ny][curr[2]]) continue;
          visited[nx][ny][curr[2]] = true;
          q.offer(new int[]{nx, ny, curr[2], curr[3]+1});
        }
      }
    }

    return -1;
  }

  public static void solve(int x, int y, int key, int cnt) {
    // System.out.println("x = " + x + " y = " + y + " cnt = " + cnt + " key = " + Integer.toBinaryString(key));
    if(dp[x][y][key] <= cnt) {
      return;
    }
    if(map[x][y] == '1') {
      // System.out.println("cnt = " + cnt);
      dp[x][y][key] = cnt;
      return;
    }
    if(dp[x][y][key] <= cnt) {
      return;
    }

    dp[x][y][key] = cnt;
    for(int i=0; i<4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#') continue;
      if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
        if((key & (1 << (map[nx][ny] - 'A'))) > 0) {
          solve(nx, ny, key, cnt+1);
        }
      }
      else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
        int key2 = (key | (1 << (map[nx][ny] - 'a')));
        solve(nx, ny, key2, cnt+1);
      }else {
        solve(nx, ny, key, cnt+1);
      }
    }
  }
}
//33
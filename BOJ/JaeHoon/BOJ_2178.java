package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
  static int[][] map;
  static boolean[][] isVisit;
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};
  static int N;
  static int M;
  static int result = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N+1][M+1];
    isVisit = new boolean[N+1][M+1];
    for(int i=1; i<=N; i++) {
      String s = br.readLine();
      for(int j=1; j<=M; j++) {
        map[i][j] = s.charAt(j-1) - '0';
      }
    }
    bfs(1, 1, 1);
    System.out.println(map[N][M]);
  }
  public static void dfs(int ax, int by,int count) {
    if(ax == N && by == M) {
      result = Math.min(result, count);
      return;
    }
    isVisit[ax][by] = true;
    for(int i=0; i<4; i++) {
      int x = ax + dx[i];
      int y = by + dy[i];
      if(x > 0 && x <= N && y > 0 && y <= M) {
        if(!isVisit[x][y] && map[x][y] == 1)
          dfs(x,y,count+1);
        }
    }
    isVisit[ax][by] = false;
  }
  public static void bfs(int ax, int by,int count) {
    Queue<int []> queue = new LinkedList<>();
    queue.offer(new int[] {ax, by});
    isVisit[ax][by] = true;
    while(!queue.isEmpty()) {
      int[] node = queue.poll();
      if(node[0] == N && node[1] == M) {
        result = Math.min(result, count);
      }
      for(int i=0; i<4; i++) {
        int x = node[0] + dx[i];
        int y = node[1] + dy[i];
        if(x > 0 && x <= N && y > 0 && y <= M) {
          if(!isVisit[x][y] && map[x][y] != 0) {
            isVisit[x][y] = true;
            queue.offer(new int[] {x,y});
            count++;
            map[x][y] = map[node[0]][node[1]] + 1;
          }
        }
      }
    }
  }
}

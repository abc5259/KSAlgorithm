package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
  static int[][] map;
  static boolean[][] isVisit;
  static Queue<int[]> queue = new LinkedList<>();
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};
  static int N;
  static int M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    isVisit = new boolean[N][M];
    int count = 0;
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        int item = Integer.parseInt(st.nextToken());
        map[i][j] = item;
        if(item == 1) {
          queue.offer(new int[] {i,j});
          isVisit[i][j] = true;
        }
        if(item > -1) count++;
      }
    }
    if(!queue.isEmpty()) 
      bfs();
    int result = 0;
    int length = 0;
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        result = Math.max(result, map[i][j]);
        if(map[i][j] >=1 )
          length++;
      }
    }
    if(count != length) 
      System.out.println(-1);
    else 
      System.out.println(result-1);
  }
  public static void bfs() {
    while(!queue.isEmpty()) {
      int[] node = queue.poll();
      for(int i=0; i<4; i++) {
        int x = node[0] + dx[i];
        int y = node[1] + dy[i];
        if(x >= 0 && x < N && y >= 0 && y < M) {
          if(!isVisit[x][y] && map[x][y] == 0) {
            queue.offer(new int[] {x,y});
            isVisit[x][y] = true;
            map[x][y] = map[node[0]][node[1]] + 1;
          }
        }
      }
    }
  }
}

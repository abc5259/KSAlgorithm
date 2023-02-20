package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14497 {
  static int N,M;
  static int[] start = new int[2];
  static int[] end = new int[2];
  static char[][] map;
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,1,-1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    start = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
    end = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

    map = new char[N+1][M+1];
    for(int i=1; i<=N; i++) {
      String s = br.readLine();
      for(int j=1; j<=M; j++) {
        map[i][j] = s.charAt(j-1);
      }
    }
    System.out.println(dfs(0));
  }
  public static int dfs(int cnt) {
    if(bfs()) {
      return cnt+1;
    }else {
      return dfs(cnt+1);
    }
  }
  public static boolean bfs() {
    Queue<int[]> q = new LinkedList<>();
    boolean[][] isVisit = new boolean[N+1][M+1];
    q.offer(new int[]{start[0],start[1]});
    isVisit[start[0]][start[1]] = true;
    while(!q.isEmpty()) {
      int[] curr = q.poll();
      for(int i=0; i<4; i++) {
        int nextX = curr[0] + dx[i];
        int nextY = curr[1] + dy[i];

        if(nextX <= 0 || nextX >= N+1 || nextY <= 0 || nextY >= M+1 || isVisit[nextX][nextY]) continue;
        isVisit[nextX][nextY] = true;
        if(map[nextX][nextY] == '1') map[nextX][nextY] = '0';
        else if(map[nextX][nextY] == '#') return true;
        else q.offer(new int[]{nextX,nextY});
      }
    }
    return false;
  }
}

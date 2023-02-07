package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638 {
  static int N,M;
  static int[][] map;
  static Queue<int[]> q = new LinkedList<>();
  static int[] dx = {1,-1,0,0};
  static int[] dy = {0,0,1,-1};
  static boolean[][] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    isVisit = new boolean[N][M];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 1) q.offer(new int[]{i,j});
      } 
    }
    settingOx(0,0);
    // println();
    System.out.println(bfs());
  }
  public static int bfs() {
    int size = q.size();
    int cnt = 0;
    int answer = 0;
    while(!q.isEmpty()) {
      int[] curr = q.poll();
      cnt++;

      if(!check(curr[0], curr[1])) {
        map[curr[0]][curr[1]] = -1; //제거해야 하므로 표시
      }else {
        q.offer(curr); // 제거해야할게 아니면 다시 큐로 넣기 
      }

      if(cnt == size) {



        if(q.isEmpty()) { // 큐가 비워져 있다면 끝
          return answer + 1;
        }

        cnt = 0;
        size = q.size();
        answer++; //시간 +1 
        melt(); // 치즈 녹이기 
        isVisit = new boolean[N][M];
        settingOx(0,0);
        
      }
    }
    return answer;
  }
  public static void println() {
    for(int i=0; i<N; i++) {
      System.out.println(Arrays.toString(map[i]));
    }
    System.out.println();
  }
  public static void melt() {
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(map[i][j] == -1) map[i][j] = 0;
      } 
    }
  }
  public static boolean check(int x, int y) {
    int oxCnt = 0;
    for(int i=0; i<4; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];

      if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
      if(map[nextX][nextY] == 2) oxCnt++;
      if(oxCnt >= 2) return false;
    }
    return true;
  }
  public static void settingOx(int x, int y) {
    isVisit[x][y] = true;
    map[x][y] = 2;
    for(int i=0; i<4; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];

      if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || isVisit[nextX][nextY]) continue;
      if(map[nextX][nextY] != 1) {
        settingOx(nextX, nextY);
      }
    }
  }
}

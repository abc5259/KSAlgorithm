package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
  static int N,M;
  static int[][] map;
  static int[] dx = {1,-1,0,0};
  static int[] dy = {0,0,1,-1};
  static boolean[][] isVisit;
  static Queue<int[]> q = new LinkedList<>();
  static int[] answers = new int[2];
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

    findOx(0, 0);
    melt();
    System.out.println(answers[0]);
    System.out.println(answers[1]);
  }
  public static void melt() {
    int cnt = 0;
    int size = q.size();
    int answer = 0;
    while(!q.isEmpty()) {
      cnt++;  
      int[] curr = q.poll();

      if(check(curr[0], curr[1])) { // 공기에 접촉한 거라면 
        map[curr[0]][curr[1]] = 2; // 녹을 치즈 
      }else {
        q.offer(curr);
      }

      if(cnt == size) {
        if(q.size() == 0) {
          answers[0] = answer + 1;
          answers[1] = size;
          return;
        }

        size = q.size();
        cnt = 0;
        answer++;
        for(int i=0; i<N; i++) {
          for(int j=0; j<M; j++) {
            if(map[i][j] == 2) {
              map[i][j] = -1;
            }
          }
        }
        isVisit = new boolean[N][M];
        findOx(0, 0);
      }
    }
  }
  public static boolean check(int x, int y) {
    for(int i=0; i<4; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];
      if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
      if(map[nextX][nextY] == -1) return true;
    }
    return false;
  }
  public static void findOx(int x, int y) {
    isVisit[x][y] = true;
    map[x][y] = -1;
    for(int i=0; i<4; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];
      if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || isVisit[nextX][nextY]) continue;
      if(map[nextX][nextY] != 1) 
        findOx(nextX, nextY);
    }
  }
}

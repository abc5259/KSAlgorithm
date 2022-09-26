package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16988 {
  static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
  static int[][] board;
  static boolean[][] isVisit;
  static int N,M;
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    isVisit = new boolean[N][M];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    bt(0,0,0);
    System.out.println(answer);
  }
  static public void bt(int row, int col,int depth) {
    if(depth == 2) {
      boolean[][] isVisit = new boolean[N][M];
      int cnt = 0;
      for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
          if(board[i][j] == 2 && !isVisit[i][j]) {
            cnt += bfs(new int[]{i,j}, isVisit);
          }
        }
      }
      answer = Math.max(answer, cnt);
      return;
    }

    for(int i=row; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(board[i][j] == 0) {
          board[i][j] = 1;
          bt(i,j,depth + 1);
          board[i][j] = 0;
        }
      }
    }
  }

  static public int bfs(int[] start,boolean[][] isVisit) {
    Queue<int[]> q = new LinkedList<>();
    isVisit[start[0]][start[1]] = true;
    q.offer(start);
    boolean isZeroDot = false;
    int total = 1;
    while(!q.isEmpty()) {
      int[] curr = q.poll();
      for(int i=0; i<4; i++) {
        int nextX = curr[0] + dir[i][0];
        int nextY = curr[1] + dir[i][1];
        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || isVisit[nextX][nextY]) continue;
        if(board[nextX][nextY] == 0) {
          isZeroDot = true;
        }
        if(board[nextX][nextY] == 2) {
          total++;
          q.offer(new int[]{nextX,nextY});
          isVisit[nextX][nextY] = true;
        }
      }
    }
    if(isZeroDot) return 0;
    return total;
  }
}

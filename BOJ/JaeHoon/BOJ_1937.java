package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937 {

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int[][] board;
  static int[][] cnts;
  static int[][] dp;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    board = new int[N][N];
    dp = new int[N][N];
    for (int i = 0; i < N; i++) { 
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    cnts = new int[N][N];
    for(int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        // dp[i][j] = 1;
        for(int d=0; d<4; d++) {
          int nx = i + dx[d];
          int ny = j + dy[d];
          if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
          if(board[i][j] < board[nx][ny]) {
            cnts[i][j]++;
          }
        }
      }
    }

    int answer = 0;
    for(int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        answer = Math.max(answer,solve(i, j));
      }
    }
    System.out.println(answer);
  }

  public static int solve(int x, int y) {
    if(dp[x][y] > 1) {
      return dp[x][y];
    }
    
    if(cnts[x][y] == 0) {
      return 1;
    }

    int mmax = 1;
    for(int d=0; d<4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if(board[x][y] >= board[nx][ny]) continue;
        mmax = Math.max(mmax, 1 + solve(nx, ny));
    }

    return dp[x][y] = mmax;
  }
}

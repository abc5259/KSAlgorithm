package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17492 {
  static int N;
  static int[][] board;
  static int[] dx = {1,1,1,0,0,-1,-1,-1};
  static int[] dy = {-1,0,1,1,-1,-1,0,1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    board = new int[N][N];
    int cnt = 0;
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if(board[i][j] == 2) cnt++;
      }
    }

    System.out.println(dfs(cnt) ? "Possible" : "Impossible");
  }
  public static boolean dfs(int cnt) {
    if(cnt <= 1) return true;

    for(int r=0; r<N; r++) {
      for(int c=0; c<N; c++) {
        if(board[r][c] == 2) {
          for(int i=0; i<8; i++) {
            int nextX = r + dx[i];
            int nextY = c + dy[i];
            if(!check(nextX,nextY)) continue;
            if(board[nextX][nextY] == 2) { //해당 방향에 바둑알이 있다면
              nextX += dx[i];
              nextY += dy[i];
              if(!check(nextX, nextY)) continue; 
              if(board[nextX][nextY] == 0) { //갈려고 하는 방향이 빈칸이라면 ㄱㄱ 
                board[r][c] = 0;
                board[nextX - dx[i]][nextY - dy[i]] = 0;
                board[nextX][nextY] = 2;
                if(dfs(cnt - 1)) return true;
                board[r][c] = 2;
                board[nextX - dx[i]][nextY - dy[i]] = 2;
                board[nextX][nextY] = 0;
              }
            }
          }
        }
      }      
    }

    return false;

  }
  public static boolean check(int x, int y) {
    if(x < 0 || x >= N || y < 0 || y >= N) return false;
    return true;
  }
}

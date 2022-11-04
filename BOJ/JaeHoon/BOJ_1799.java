package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1799 {
  static int[][] white;
  static int[][] black;
  static int N;
  static int[][] dir = {{1,1},{1,-1},{-1,1},{-1,-1}};
  static int max = Integer.MIN_VALUE;
  static int max2 = Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    white = new int[N][N];
    black = new int[N][N];
    for(int i=0; i<N; i++) {
      Arrays.fill(white[i], -2);
      Arrays.fill(black[i], -2);
    }
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        int n = Integer.parseInt(st.nextToken());
        if((i+j) % 2 == 0) {
          white[i][j] = n;
        }else {
          black[i][j] = n;
        }
      }
    }
    dfs(white,0, 0, 0);
    dfs2(black, 0, 0, 0);

    System.out.println(max+max2);
  }
  static void dfs(int[][] board, int row, int col, int cnt) {
    max = Math.max(max, cnt);
    if(row == N) {
      return;
    }

    if(col == N) {
      dfs(board,row+1,0, cnt);
      return;
    }

    if(board[row][col] == 0 || board[row][col] == -2) {
      dfs(board, row, col+1, cnt);
      return;
    }

    if(check(board, row, col)) {
      board[row][col] = -1;
      dfs(board , row, col+1, cnt+1);
      board[row][col] = 1;
    }
    dfs(board , row, col+1, cnt);
  }
  static void dfs2(int[][] board, int row, int col, int cnt) {
    max2 = Math.max(max2, cnt);
    if(row == N) {
      return;
    }

    if(col == N) {
      dfs2(board,row+1,0, cnt);
      return;
    }

    if(board[row][col] == 0 || board[row][col] == -2) {
      dfs2(board, row, col+1, cnt);
      return;
    }
    if(check(board, row, col)) {
      board[row][col] = -1;
      dfs2(board , row, col+1, cnt+1);
      board[row][col] = 1;
    }
    dfs2(board , row, col+1, cnt);
  }
  static boolean check(int[][] board, int row, int col) {
    int nextX = row;
    int nextY = col;
    while(nextX > -1 && nextX < N && nextY > -1 && nextY < N) {
      nextX += dir[0][0];
      nextY += dir[0][1];
      if(nextX > -1 && nextX < N && nextY > -1 && nextY < N)  {
        if(board[nextX][nextY] == -1) return false;
      }
    }

    nextX = row;
    nextY = col;
    while(nextX > -1 && nextX < N && nextY > -1 && nextY < N) {
      nextX += dir[1][0];
      nextY += dir[1][1];
      if(nextX > -1 && nextX < N && nextY > -1 && nextY < N)  {
        if(board[nextX][nextY] == -1) return false;
      }
    }

    nextX = row;
    nextY = col;
    while(nextX > -1 && nextX < N && nextY > -1 && nextY < N) {
      nextX += dir[2][0];
      nextY += dir[2][1];
      if(nextX > -1 && nextX < N && nextY > -1 && nextY < N)  {
        if(board[nextX][nextY] == -1) return false;
      }
    }

    nextX = row;
    nextY = col;
    while(nextX > -1 && nextX < N && nextY > -1 && nextY < N) {
      nextX += dir[3][0];
      nextY += dir[3][1];
      if(nextX > -1 && nextX < N && nextY > -1 && nextY < N)  {
        if(board[nextX][nextY] == -1) return false;
      }
    }
    
    return true;
  }
}

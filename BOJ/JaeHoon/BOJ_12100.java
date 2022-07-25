package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12100 {
  static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
  static int[][] changeBoard;
  static int max = Integer.MIN_VALUE;
  static int N;
  static boolean[][] visit;
  static int[][] copyBoard;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    N = Integer.parseInt(br.readLine());
    int[][] board = new int[N][N];
    visit = new boolean[N][N];
    changeBoard = new int[N][N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        int n = Integer.parseInt(st.nextToken());
        board[i][j] = n;
      } 
    }
    dfs(0,board);
    System.out.println(max);
  }
  public static void dfs(int pos, int[][] board) {
    if(pos == 5) {
      int result = 0;
      for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
          result = Math.max(result, board[i][j]);
        }
      }
      max = Math.max(max, result);
      return;
    }
    for(int k=0; k<4; k++) {
      visit = new boolean[N][N];
      copyBoard = new int[N][N];
        for(int i=0; i<N; i++) {
          for(int j=0; j<N; j++) {
            copyBoard[i][j] = board[i][j];
          }
        }
      if(k == 0) {
        for(int i=N-2; i>=0; i--) {
          for(int j=0; j<N; j++) {
            if(copyBoard[i][j] == 0) continue;
            int cntX = i;
            int cntY = j;
            int nextX = i + dir[k][0];
            int nextY = j + dir[k][1];
            while(nextX < N) {
              if(visit[nextX][nextY]) break;
              if(copyBoard[nextX][nextY] != 0 && copyBoard[nextX][nextY] != copyBoard[cntX][cntY]) break;
              if(copyBoard[nextX][nextY] != 0 && copyBoard[nextX][nextY] == copyBoard[cntX][cntY]) {
                copyBoard[nextX][nextY] *= 2;
                copyBoard[cntX][cntY] = 0;
                visit[nextX][nextY] = true;
                break;
              }
              copyBoard[nextX][nextY] = copyBoard[cntX][cntY];
              copyBoard[cntX][cntY] = 0;
              cntX = nextX;
              cntY = nextY;
              nextX += dir[k][0];
              nextY += dir[k][1];
            } 
          }
        }
        dfs(pos+1, copyBoard);
      }
      else if(k == 1) {
        for(int l=0; l<N; l++)
            System.out.println(Arrays.toString(copyBoard[l]));
          System.out.println();
        for(int i=1; i<N; i++) {
          for(int j=0; j<N; j++) {
            if(copyBoard[i][j] == 0) continue;
            int cntX = i;
            int cntY = j;
            int nextX = i + dir[k][0];
            int nextY = j + dir[k][1];
            while(nextX >= 0) {
              if(visit[nextX][nextY]) break;
              if(copyBoard[nextX][nextY] != 0 && copyBoard[nextX][nextY] != copyBoard[cntX][cntY]) break;
              if(copyBoard[nextX][nextY] != 0 && copyBoard[nextX][nextY] == copyBoard[cntX][cntY]) {
                copyBoard[nextX][nextY] *= 2;
                copyBoard[cntX][cntY] = 0;
                visit[nextX][nextY] = true;
                break;
              }
              copyBoard[nextX][nextY] = copyBoard[cntX][cntY];
              copyBoard[cntX][cntY] = 0;
              cntX = nextX;
              cntY = nextY;
              nextX += dir[k][0];
              nextY += dir[k][1];
            } 
          }
        }
        dfs(pos+1, copyBoard);
      }
      else if(k == 2) {
        for(int i=1; i<N; i++) {
          for(int j=0; j<N; j++) {
            if(copyBoard[j][i] == 0) continue;
            int cntX = j;
            int cntY = i;
            int nextX = j + dir[k][0];
            int nextY = i + dir[k][1];
            while(nextY >= 0) {
              if(visit[nextX][nextY]) break;
              if(copyBoard[nextX][nextY] != 0 && copyBoard[nextX][nextY] != copyBoard[cntX][cntY]) break;
              if(copyBoard[nextX][nextY] != 0 && copyBoard[nextX][nextY] == copyBoard[cntX][cntY]) {
                copyBoard[nextX][nextY] *= 2;
                copyBoard[cntX][cntY] = 0;
                visit[nextX][nextY] = true;
                break;
              }
              copyBoard[nextX][nextY] = copyBoard[cntX][cntY];
              copyBoard[cntX][cntY] = 0;
              cntX = nextX;
              cntY = nextY;
              nextX += dir[k][0];
              nextY += dir[k][1];
            } 
          }
        }
        dfs(pos+1, copyBoard);
      }
      else if(k == 3) {
        for(int i=N-2; i>=0; i--) {
          for(int j=0; j<N; j++) {
            if(copyBoard[j][i] == 0) continue;
            int cntX = j;
            int cntY = i;
            int nextX = j + dir[k][0];
            int nextY = i + dir[k][1];
            while(nextY < N) {
              if(visit[nextX][nextY]) break;
              if(copyBoard[nextX][nextY] != 0 && copyBoard[nextX][nextY] != copyBoard[cntX][cntY]) break;
              if(copyBoard[nextX][nextY] != 0 && copyBoard[nextX][nextY] == copyBoard[cntX][cntY]) {
                copyBoard[nextX][nextY] *= 2;
                copyBoard[cntX][cntY] = 0;
                visit[nextX][nextY] = true;
                break;
              }
              copyBoard[nextX][nextY] = copyBoard[cntX][cntY];
              copyBoard[cntX][cntY] = 0;
              cntX = nextX;
              cntY = nextY;
              nextX += dir[k][0];
              nextY += dir[k][1];
            } 
          }
        }
        dfs(pos+1, copyBoard);
      }
    }
  }
}

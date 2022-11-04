package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913 {
  static int[][] board;
  static int N;
  static boolean up,down,left,rigth = false;
  static int limitCnt = 1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int find = Integer.parseInt(br.readLine());
    board = new int[N][N];

    solve(N*N,0,0,1,N,"down");
    StringBuffer sb = new StringBuffer();
    int[] arr = new int[2];
    for(int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        int n = board[i][j] == 0 ? 4 : board[i][j];
        if(find == n) {
          arr = new int[]{i,j};
        }
        sb.append(n).append(" ");
      }
      sb.append('\n');
    }
    sb.append((arr[0]+1) + " " + (arr[1]+1));
    System.out.println(sb);
  }

  // 5 4  4 3 3 2 2 1 1
  static public void solve(int num, int row, int col, int cnt, int limit, String dir) {

    while(num >= 0) {
      board[row][col] = num;
      if(cnt == limit) {
        if(dir.equals("down")) {
          limitCnt++;
          if(limitCnt == 2) {
            limitCnt = 0;
            num--;
            col += 1;
            cnt = 1;
            limit -= 1;
            dir = "right";
          }
          else  {
            num--;
            col += 1;
            cnt = 1;
            dir = "right";
          }  
        } 
        else if(dir.equals("up")) {
          limitCnt++;
          if(limitCnt == 2) {
            limitCnt = 0;
            num--;
            col -= 1;
            cnt = 1;
            limit -= 1;
            dir = "left";
          }
          else  {
            num--;
            col -= 1;
            cnt = 1;
            dir = "left";
          }
            
        }
        else if(dir.equals("left")) {
          limitCnt++;
          if(limitCnt == 2) {
            limitCnt = 0;
            num--;
            row += 1;
            cnt = 1;
            limit -= 1;
            dir = "down";
          }
          else  {
            num--;
            row += 1;
            cnt = 1;
            dir = "down";
          }
        }
        else if(dir.equals("right")) {
          limitCnt++;
          if(limitCnt == 2) {
            limitCnt = 0;
            num--;
            row -= 1;
            cnt = 1;
            limit -= 1;
            dir = "up";
          }
          else {
            num--;
            row -= 1;
            cnt = 1;
            dir = "up";
          }
        }
      }else {
        if(dir.equals("left")) {
          num -= 1;
          col -= 1;
          cnt += 1;
        }
        else if(dir.equals("right")) {
          num -= 1;
          col += 1;
          cnt += 1;
        }
        else if(dir.equals("up")) {
          num -= 1;
          row -= 1;
          cnt += 1;
        }
        else if(dir.equals("down")) {
          num -= 1;
          row += 1;
          cnt += 1;
        }
      }
    }
  }
}

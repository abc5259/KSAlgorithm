package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1331 {
  static int[][] dir = {{2,1},{-2,1},{2,-1},{-2,-1},{1,-2},{1,2},{-1,-2},{-1,2}};
  static int[][] isVisit = new int[6][6];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int y = s.charAt(0) - 'A';
    int x =  6 - (s.charAt(1) - '0');
    isVisit[x][y] = 1;
    boolean answer = true;
    for(int i=1; i<36; i++) {
      s = br.readLine();
      if(!answer) continue;
      int goY = s.charAt(0) - 'A';
      int goX =  6 - (s.charAt(1) - '0');
      boolean isOk = false;
      for(int d=0; d<8; d++) {
        int nextX = dir[d][0] + x;
        int nextY = dir[d][1] + y;
        if(nextX < 0 || nextX >= 6 || nextY < 0 || nextY >= 6 || isVisit[nextX][nextY] != 0) continue;

        if(nextX == goX && nextY == goY) {
          isOk = true;
          x = goX;
          y = goY;
          isVisit[nextX][nextY] = i+1;
          break;
        }
      }
      
      if(!isOk){
        answer = false;
      }

    }
    boolean isOk = false;
    for(int d=0; d<8; d++) {
      int nextX = dir[d][0] + x;
      int nextY = dir[d][1] + y;
      if(nextX < 0 || nextX >= 6 || nextY < 0 || nextY >= 6 || isVisit[nextX][nextY] != 1) continue;
      isOk = true;
    }
    if(!isOk){
      answer = false;
    }
    System.out.println(answer ? "Valid" : "Invalid");
  }
}

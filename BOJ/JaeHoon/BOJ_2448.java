package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2448 {
  static StringBuffer sb = new StringBuffer();
  static char[][] map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    map = new char[N][2*N-1];
    for(int i=0; i<N; i++) {
      for(int j=0; j<2*N-1; j++) {
        map[i][j] = ' ';
      }
    }
    draw(0, N-1, N);
    for(int i=0; i<N; i++) {
      for(int j=0; j<2*N-1; j++) {
        sb.append(map[i][j]);
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
  public static void draw(int x, int y, int n) { 
    if(n == 3) {
      map[x][y] = '*';
      map[x+1][y-1] = map[x+1][y+1] = '*';
      for(int i=y-2; i<=y+2; i++) 
        map[x+2][i] = '*';
      return;
    }

    draw(x,y,n/2);
    draw(x+n/2,y-n/2,n/2);
    draw(x+n/2,y+n/2,n/2);
  }
}

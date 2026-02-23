package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14939 {
  static int[] dx = {0,0,-1,1,0};
  static int[] dy = {1,-1,0,0,0};
  static int result = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] bits = new int[10];
    for(int i=0; i<10; i++) {
      String s = br.readLine();
      for(int j=0; j<10; j++) {
        if(s.charAt(j) == 'O') {
          bits[i] = bits[i] | (1<<j);
        }
      } 
    }

    for(int i=0; i<1<<10; i++) {
      int[] newBits = bits.clone();

      int cnt = 0;
      for(int j=0; j<10; j++) {
        if((i & (1<<j)) > 0) {
          press(newBits, 0, j);
          cnt++;
        }
      }

      dfs(1, newBits, cnt);
    }

    System.out.println(result == Integer.MAX_VALUE ? -1 : result);
  }

  public static void dfs(int depth, int[] bits, int cnt) {
    if(depth == 10) {
      boolean check = true;
      for(int i=0; i<10; i++) {
        if(bits[i]!= 0) {
          check = false;
          break;
        }
      }
      if(check) {
        result = Math.min(result, cnt);
      }
      return;
    }

    int sum = 0;
    for(int i=0; i<10; i++) {
      if((bits[depth-1] & (1<<i)) > 0) {
        press(bits, depth, i);
        sum++;
      }
    }
    dfs(depth+1, bits, cnt+sum);
  }

  public static void press(int[] bits, int x, int y) {
    for(int d=0; d<5; d++) {
      int nx = x + dx[d];
      int ny = y + dy[d];
      if(nx < 0 || nx >= 10 || ny < 0 || ny >= 10) continue;
      if((bits[nx] & (1<<ny)) > 0) {
        bits[nx] = bits[nx] & ~(1<<ny);
      }else {
        bits[nx] = bits[nx] | (1<<ny);
      }
    }
  }
}

package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_9663 {
  static int[][] map;
  static int N;
  static int cnt = 0;
  static boolean[] isUsed1 = new boolean[40];
  static boolean[] isUsed2 = new boolean[40];
  static boolean[] isUsed3 = new boolean[40];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    
    dfs(0);
    System.out.println(cnt);
  }
  public static void dfs(int depth) {
    if(depth == N) {
      cnt++;
      return;
    }   
    for(int i=0; i<N; i++) {
      if(isUsed1[i] || isUsed2[depth+i] || isUsed3[depth-i+N-1]) continue;
      isUsed1[i] = true;
      isUsed2[depth+i] = true;
      isUsed3[depth-i+N-1] = true;
      dfs(depth+1);
      isUsed1[i] = false;
      isUsed2[depth+i] = false;
      isUsed3[depth-i+N-1] = false;
    }
  }
 
}

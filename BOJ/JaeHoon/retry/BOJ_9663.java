package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
  static int N;
  static boolean[] isUsed1;
  static boolean[] isUsed2;
  static boolean[] isUsed3;
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    
    isUsed1 = new boolean[N+1];
    isUsed2 = new boolean[31];
    isUsed3 = new boolean[31];
   
    solve(0);
    System.out.println(answer);
  }
  public static void solve(int row) {
    if(row == N) {
      answer++;
      return;
    }
    for(int c=0; c<N; c++) {
      if(isUsed1[c] || isUsed2[row - c + N-1] || isUsed3[row+c]) continue;
      isUsed1[c] = true;
      isUsed2[row - c + N-1] = true;
      isUsed3[row+c] = true;
      solve(row+1);
      isUsed1[c] = false;
      isUsed2[row - c + N-1] = false;
      isUsed3[row+c] = false;
    }
  }
}

package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    System.out.println(solve(N));
  }
  public static int solve(int idx) {
    if(idx == 0) return 0;
    if(idx == 1) return 1;
    return solve(idx-1) + solve(idx-2);
    
  }
}

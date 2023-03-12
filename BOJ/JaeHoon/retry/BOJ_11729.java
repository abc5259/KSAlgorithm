package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
  static StringBuffer sb = new StringBuffer();
  static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    solve(N, 1, 3, 2);
    System.out.println(answer);
    System.out.println(sb);
  }
  public static void solve(int n, int from, int to, int other) {
    if(n == 0) return;
    answer++;
    
    solve(n-1, from, other, to);
    sb.append(from + " " + to + "\n");
    solve(n-1, other, to, from);
  }
}

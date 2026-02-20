package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2618 {
  static int[][] arr;
  static int N,W;
  static int[][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    W = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    arr = new int[W+3][2];
    for(int i=1; i<=W; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    arr[W+1][0] = 1;
    arr[W+1][1] = 1;
    arr[W+2][0] = N;
    arr[W+2][1] = N;
    dp = new int[W+3][W+3];

    int result = solve(1, W+1, W+2);
    sb.append(result).append('\n');
    int pos1 = W+1;
    int pos2 = W+2;
    for(int i=1; i<=W; i++) {
      int d = dist(arr[pos1][0], arr[pos1][1], arr[i][0], arr[i][1]);
      if(dp[pos1][pos2] - d == dp[i][pos2]) {
        sb.append("1\n");
        pos1 = i;
      }else {
        sb.append("2\n");
        pos2 = i;
      }
    }
    System.out.print(sb);
  }

  public static int solve(int go, int index1, int index2) {
    if(go == W+1) {
      return 0;
    }

    if(dp[index1][index2] != 0) {
      return dp[index1][index2];
    }

    int a = solve(go+1, go, index2) + dist(arr[index1][0], arr[index1][1], arr[go][0], arr[go][1]);
    int b = solve(go+1, index1, go) + dist(arr[index2][0], arr[index2][1], arr[go][0], arr[go][1]);

    return dp[index1][index2] = Math.min(a, b);
  }

  public static int dist(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }
}

package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5557 {
  static int N;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    long[][] dp = new long[N-1][21];

    dp[0][arr[0]] = 1;
    for(int i=1; i<N-1; i++) {
      for(int j=0; j<=20; j++) {
        if(j + arr[i] <= 20) {
          dp[i][j + arr[i]] += dp[i-1][j];
        }
        if(j - arr[i] >= 0) {
          dp[i][j - arr[i]] += dp[i-1][j];
        }
      }
    }
    // for(int i=0; i<N-1; i++) System.out.println(Arrays.toString(dp[i]));
    System.out.println(dp[N-2][arr[N-1]]);
  }
}

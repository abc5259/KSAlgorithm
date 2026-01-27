package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10653 {
  static int[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    arr = new int[N+1][2];

    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }


    int[][] dp = new int[N+1][K+1];

    for(int i=1; i<=N; i++) Arrays.fill(dp[i], 100000000);
    dp[1][0] = 0;
    dp[2][0] = dist(1, 2);

    for(int i=3; i<=N; i++) {
      dp[i][0] = dp[i-1][0] + dist(i, i-1);
      for(int k=1; k<=Math.min(i-2, K); k++) {
        dp[i][k] = dp[i-1][k] + dist(i-1, i); //안 건너뜀 
        for(int j=k; j>=1; j--) {
          dp[i][k] = Math.min(dp[i][k], dp[i-(j+1)][k-j] + dist(i-(j+1), i));
        }
      }
    }

    int result = Integer.MAX_VALUE;
    for(int i=0; i<=K; i++) {
        result = Math.min(result, dp[N][i]);
    }
    System.out.println(result);
  }

  public static int dist (int i, int j) {
    return Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]);
  }
}

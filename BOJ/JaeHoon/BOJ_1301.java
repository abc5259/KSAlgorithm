package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1301 {
  // 17분 
  static long[][][][][][][] dp;
  static int cnt;
  static int N;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    // 구슬 종류 3 <= N  <= 5
    // 각각의 구슬은 1~10
    // N N-1 N-2 N-2 .... 구슬개수 5^3
    // 최적화 그리디, dp 
    // 그리디 
    // dp 점화식 
    // dp[구슬개수][구슬종류] = 현재 구슬개수에 해당 구슬 종류로 목걸이를 만들때 나올 수 있는 경우의수
    // dp[구슬개수][1] = dp[구슬개수-2][2] + dp[구슬개슈-1][3] ~ 나머지 , dp[]
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[6];
    cnt = 0;
    for(int i=1; i<=N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      cnt += arr[i];
    }
    
    dp = new long[N+1][N+1][11][11][11][11][11];
    for (int i = 0; i < N+1; i++)
            for (int j = 0; j < N+1; j++)
                for (int a = 0; a < 11; a++)
                    for (int b = 0; b < 11; b++)
                        for (int c = 0; c < 11; c++)
                            for (int d = 0; d < 11; d++)
                                Arrays.fill(dp[i][j][a][b][c][d], -1);

    long result = solve(0, 0, 0);
  
    System.out.println(result);
  }
    public static long solve(int depth, int prev, int n) {
    if(depth == cnt) {
      return 1;
    }

    if (dp[prev][n][arr[1]][arr[2]][arr[3]][arr[4]][arr[5]] != -1) {
      return dp[prev][n][arr[1]][arr[2]][arr[3]][arr[4]][arr[5]];
    }

    long sum = 0;
    for(int i=1; i<=N; i++) {
      if(i == prev || i == n) continue;
      if(arr[i] <= 0) continue;
      arr[i]--;
      sum += solve(depth+1, n, i);
      arr[i]++;
    }
    
    return dp[prev][n][arr[1]][arr[2]][arr[3]][arr[4]][arr[5]] = sum;
  }
}

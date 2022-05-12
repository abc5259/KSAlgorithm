package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_1932 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[][] arr = new int[N][N];
    int[][] dp = new int[N][N];
    for(int i=0; i<N; i++) {
      for(int j=0; j<i+1; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    dp[0][0] = arr[0][0];
    for(int i=1; i<N; i++) {
      for(int j=0; j<i+1; j++) {
        if(j == 0) {
          dp[i][j] = dp[i-1][j] + arr[i][j];
        }
        else if(j == i) {
          dp[i][j] = dp[i-1][j-1] + arr[i][j];
        }
        else {
          dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
        }
      }
    }
    int max = dp[N-1][0];
    for(int i=1; i<N; i++){
      if(max < dp[N-1][i]) max = dp[N-1][i];
    }
    System.out.println(max);
  }
}

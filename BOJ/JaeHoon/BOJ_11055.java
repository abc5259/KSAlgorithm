package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_11055 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N+1];
    int[] dp = new int[N+1];
    for(int i=1; i<N+1; i++) {
      arr[i] = sc.nextInt();
    }
    dp[1] = arr[1];
    for(int i=2; i<N+1; i++) {
      dp[i] = arr[i];
      for(int j=1; j<i; j++) {
        if(arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i],dp[j] + arr[i]);
        }
      }
    }
    int max = dp[1];
    for(int i=1; i<N+1; i++) {
      if(dp[i] > max) max = dp[i];
    }
    System.out.println(max);
  }
}

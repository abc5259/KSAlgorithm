package BOJ.JaeHoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11722 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    int[] dp = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.fill(dp, 1);
    for(int i=1; i<N; i++) {
      for(int j=0; j<i; j++) {
        if(arr[i] < arr[j] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
        }
      }
    }
    int max = dp[0];
    for(int i=1; i<N; i++) {
      if(dp[i] > max) max = dp[i];
    }
    System.out.println(max);
  }
}

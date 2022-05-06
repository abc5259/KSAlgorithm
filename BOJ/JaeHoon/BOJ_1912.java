package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_1912 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    int[] dp = new int[N];
    arr[0] = dp[0] = sc.nextInt(); 
    for(int i=1; i<N; i++) {
      arr[i] = sc.nextInt();
      if(arr[i] < dp[i-1] + arr[i]) {
        dp[i] = dp[i-1] + arr[i];
      }else {
        dp[i] = arr[i];
      }
    }
    int max = dp[0];
    for(int i=1; i<N; i++) {
      if(max <dp[i]) max = dp[i];
    }
    System.out.println(max);
  }
}

package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_11054 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    int[] dp1 = new int[N];
    int[] dp2 = new int[N];
    int[] resultDP = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = sc.nextInt();
    }
    dp1[0] = 1;
    dp2[N-1] = 1;
    for(int i=1; i<N; i++) {
      dp1[i] = 1;
      for(int j=0; j<i; j++) {
        if(arr[j] < arr[i] && dp1[i] < dp1[j] + 1) {
          dp1[i] = dp1[j] + 1;
        }
      }
    }
    for(int i=N-2; i>=0; i--) {
      dp2[i] = 1;
      for(int j=N-1; j>i; j--) {
        if(arr[j] < arr[i] && dp2[i] < dp2[j] + 1) {
          dp2[i] = dp2[j] + 1;
        }
      }
    }
    for(int i=0; i<N; i++) {
      resultDP[i] = dp1[i] + dp2[i] -1;
    }
    int max = 0;
    for(int i=0; i<N; i++) {
      if(max < resultDP[i]) max = resultDP[i];
    }
    System.out.println(max);
  }
}

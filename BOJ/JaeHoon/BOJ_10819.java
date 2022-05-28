package BOJ.JaeHoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10819 {
  public static int N;
  public static int[] arr;
  public static int[] nums;
  public static int max = 0;
  public static boolean[] isUsed;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    arr = new int[N];
    nums = new int[N+1];
    isUsed = new boolean[N+1];
    for(int i=1; i<=N; i++){
      nums[i] = sc.nextInt();
    }
    func(0);
    System.out.println(max);
  }
  public static void func(int depth) {
    if(depth == N) {
      int sum = 0;
      for(int i=0; i<N-1; i++) {
        sum += Math.abs(arr[i] - arr[i+1]);
      }
      if(max < sum) max = sum;
      return;
    }
    for(int i=1; i<=N; i++) {
      if(!isUsed[i]) {
        arr[depth] = nums[i];
        isUsed[i] = true;
        func(depth + 1);
        isUsed[i] = false;
      }
    }
  }
}
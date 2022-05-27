package BOJ.JaeHoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15666 {
  public static int N;
  public static int M;
  public static int[] arr;
  public static int[] nums;
  public static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    arr = new int[M];
    nums = new int[N+1];
    for(int i=1; i<=N; i++) {
      nums[i] = sc.nextInt();
    }
    Arrays.sort(nums);
    func(0,0);
    System.out.println(sb);
  }
  public static void func(int depth, int start) {
    if(depth == M) {
      for(int i=0; i<M; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
      return;
    }
    int pick = 0;
    for(int i=1; i<=N; i++) {
      if(start <= i && pick != nums[i]) {
        arr[depth] = nums[i];
        pick = nums[i];
        func(depth + 1, i);
      }
    }
  }
}
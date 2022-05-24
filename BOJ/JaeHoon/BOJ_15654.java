package BOJ.JaeHoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654 {
  public static int N;
  public static int M;
  public static int[] arr;
  public static int[] nums;
  public static boolean[] isUsed;
  public static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    arr = new int[M];
    nums = new int[N+1];
    isUsed = new boolean[N+1];
    for(int i=1; i<=N; i++) {
      nums[i] = sc.nextInt();
    }
    Arrays.sort(nums);
    func(0);
    System.out.println(sb);
  }
  public static void func(int depth) {
    if(depth == M) {
      for(int i=0; i<M; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
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

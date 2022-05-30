package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_6603 {
  public static int K;
  public static int[] arr;
  public static int[] nums;
  public static boolean[] isUsed;
  public static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // K = sc.nextInt();
    while(true) {
     K = sc.nextInt();
     if(K == 0) break;
     arr = new int[6];
     nums = new int[K+1];
     isUsed = new boolean[K+1];
     for(int i=1; i<=K; i++) {
       nums[i] = sc.nextInt();
     }
     func(0,0);
     sb.append("\n");
    }
    System.out.println(sb);
  }
  public static void func(int depth,int start) {
    if(depth == 6) {
      for(int i=0; i<6; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append('\n');
      return;
    }
    for(int i=1; i<=K; i++) {
      if(!isUsed[i] && start < i) {
        arr[depth] = nums[i];
        isUsed[i] = true;
        func(depth+1,i);
        isUsed[i] = false;
      }
    }
  }
}

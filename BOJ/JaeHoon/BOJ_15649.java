package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_15649 {
  public static int N;
  public static int M;
  public static int[] arr;
  public static boolean[] isUsed;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    arr = new int[10];
    isUsed = new boolean[10];
    func(0);
  }
  public static void func(int depth) {
    if(depth == M) {
      for(int i=0; i<M; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }
    for(int i=1; i<=N; i++) {
      if(!isUsed[i]) {
        arr[depth] = i;
        isUsed[i] = true;
        func(depth + 1);
        isUsed[i] = false;
      }
    }
  }
}

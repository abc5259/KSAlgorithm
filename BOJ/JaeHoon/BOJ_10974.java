package BOJ.JaeHoon;

import java.util.Scanner;

public class BOJ_10974 {
  public static int N; 
  public static int[] arr;
  public static boolean[] isUsed;
  public static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    arr = new int[N];
    isUsed = new boolean[N+1];
    func(0);
    System.out.println(sb);
  }
  public static void func(int depth) {
    if(depth == N) {
      for(int i=0; i<N; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
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

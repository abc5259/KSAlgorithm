package BOJ.JaeHoon;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_14002 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuffer sb = new StringBuffer();
    int N = sc.nextInt();
    int[] arr = new int[N];
    int[] dp = new int[N];
    Stack<Integer> stack = new Stack<>();
    arr[0] = sc.nextInt();
    dp[0] = 1;
    int max = dp[0];
    int maxIndex = 0;
    for(int i=1; i<N; i++) {
      arr[i] = sc.nextInt();
      dp[i] = 1;
      for(int j=0; j<i; j++) {
        if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
        }
      }
      if(max < dp[i]) {
        max = dp[i];
        maxIndex = i;
      }
    }
    int maxDP = dp[maxIndex];
    sb.append(max).append("\n");
    for(int i = N-1; i>=0; i--) {
      if(maxDP == dp[i]) {
        stack.push(arr[i]);
        maxDP--;
      }
    }
    while(!stack.isEmpty()) {
      sb.append(stack.pop()).append(" ");
    }
    System.out.println(sb);
  }
}

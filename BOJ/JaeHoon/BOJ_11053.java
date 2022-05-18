package BOJ.JaeHoon;
import java.util.Scanner;

public class BOJ_11053 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    int[] dp = new int[N];
    arr[0] = sc.nextInt();
    dp[0] = 1;
    for(int i=1; i<N; i++) {
      arr[i] = sc.nextInt();
      dp[i] = 1;
      for(int j=0; j<i; j++) {
        if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
        }
      }
    }
    int max = dp[0];
    for(int i=0; i<dp.length; i++) {
      if(max < dp[i]) max = dp[i];
    }
    System.out.println(max); 
    
  }
}

package BOJ.JaeHoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3085 {
  static char[][] arr;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] dp = new int[N];
    arr = new char[N][N];
    for(int i=0; i<N; i++) {
      String s = sc.next();
      for(int j=0; j<N; j++) {
        arr[i][j] = s.charAt(j);
      }
    }
    int max = 1;
    for(int i=0; i<N; i++) {
      dp[0] = 1;
      for(int k=1; k<N; k++) {
        dp[k] = 1;
        if(arr[i][k] == arr[i][k-1]) {
          dp[k] = dp[k-1] + 1;
        }
      }
      Arrays.sort(dp);
      max = Math.max(max, dp[N-1]);
    }
    for(int j=0; j<N; j++) {
      dp[0] = 1;
      for(int k=1; k<N; k++) {
        dp[k] = 1;
        if(arr[k][j] == arr[k-1][j]) {
          dp[k] = dp[k-1] + 1;
        }
      }
      Arrays.sort(dp);
      max = Math.max(max, dp[N-1]);
    }
    for(int i=0; i<N; i++) {
      for(int j=0; j<N-1; j++) {
        if(arr[i][j] != arr[i][j+1]) {
          rowSwap(arr[i],j);
          dp[0] = 1;
          for(int k=1; k<N; k++) {
            dp[k] = 1;
            if(arr[i][k] == arr[i][k-1]) {
              dp[k] = dp[k-1] + 1;
            }
          }
          Arrays.sort(dp);
          max = Math.max(max, dp[N-1]);
          dp[0] = 1;
          for(int k=1; k<N; k++) {
            dp[k] = 1;
            if(arr[k][j] == arr[k-1][j]) {
              dp[k] = dp[k-1] + 1;
            }
          }
          Arrays.sort(dp);
          max = Math.max(max, dp[N-1]);
          
          dp[0] = 1;
          for(int k=1; k<N; k++) {
            dp[k] = 1;
            if(arr[k][j+1] == arr[k-1][j+1]) {
              dp[k] = dp[k-1] + 1;
            }
          }
          Arrays.sort(dp);
          max = Math.max(max, dp[N-1]);
          rowSwap(arr[i],j);
        }
      }
    }

    // colum rowSwap
    for(int i=0; i<N-1; i++) {
      for(int j=0; j<N; j++) {
        if(arr[i][j] != arr[i+1][j]) {
          columnSwap(arr,i,j);
          dp[0] = 1;
          for(int k=1; k<N; k++) {
            dp[k] = 1;
            if(arr[i][k] == arr[i][k-1]) {
              dp[k] = dp[k-1] + 1;
            }
          }
          Arrays.sort(dp);
          max = Math.max(max, dp[N-1]);
          dp[0] = 1;
          for(int k=1; k<N; k++) {
            dp[k] = 1;
            if(arr[k][j] == arr[k-1][j]) {
              dp[k] = dp[k-1] + 1;
            }
          }
          Arrays.sort(dp);
          max = Math.max(max, dp[N-1]);

          dp[0] = 1;
          for(int k=1; k<N; k++) {
            dp[k] = 1;
            if(arr[i+1][k] == arr[i+1][k-1]) {
              dp[k] = dp[k-1] + 1;
            }
          }
          Arrays.sort(dp);
          max = Math.max(max, dp[N-1]);
          columnSwap(arr,i,j);
        }
      }
    }
    System.out.println(max);
  }
  public static void rowSwap(char[] a,int j) {
    char temp = a[j];
    a[j] = a[j+1];
    a[j+1] = temp;
  }

  public static void columnSwap(char[][] a,int i,int j) {
    char temp = a[i][j];
    a[i][j] = a[i+1][j];
    a[i+1][j] = temp;
  }
}

package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_27163 {
  static int N, A, L;
  static int[][] dp;
  static int[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    A = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    dp = new int[N+1][L+1];
    for(int i=0; i<=N; i++) Arrays.fill(dp[i], -1);
    arr = new int[N+1][2];
    char[][] prev = new char[N+1][L+1];
    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[i][0] = a;
      arr[i][1] = b;
    }

    dp[0][L] = A;
    for(int i=1; i<=N; i++) {
      for(int l=1; l<=L; l++) {
        if(arr[i][0] >= 0 && arr[i][1] >= 0) {
          // 오라 공격 
          if(dp[i-1][l] >= arr[i][0]) {
            if(dp[i][l] < dp[i-1][l] - arr[i][0]) {
              dp[i][l] = dp[i-1][l] - arr[i][0];
              prev[i][l] = 'A';
            }
          }

          // 생명력 공격 
          if(l + arr[i][1] <= L && dp[i-1][l+arr[i][1]] >= 0) {
            if(dp[i][l] < dp[i-1][l+arr[i][1]]) {
              dp[i][l] = Math.max(dp[i][l], dp[i-1][l+arr[i][1]]);
              prev[i][l] = 'L';
            }
          }
        }
        else if(arr[i][0] == -1) {
          // 생명력 공격 
          if(l + arr[i][1] <= L && dp[i-1][l+arr[i][1]] >= 0) {
            if(dp[i][l] < dp[i-1][l+arr[i][1]]) {
              dp[i][l] = Math.max(dp[i][l], dp[i-1][l+arr[i][1]]);
              prev[i][l] = 'L';
            }
          }
        }else {
          // 오라 공격 
          if(dp[i-1][l] != -1) {
            if(dp[i][l] < Math.max(dp[i-1][l] - arr[i][0], 0)) {
              dp[i][l] = Math.max(dp[i-1][l] - arr[i][0], 0);
              prev[i][l] = 'A';
            }
          }
        }
      }
    }


    int life = -1;
    for(int i=1; i<=L; i++) {
      if(dp[N][i] >= 0) {
        life = i;
        break;
      }
    }
    
    if(life == -1) {
      System.out.println("NO");
      return;
    }

    System.out.println("YES");

    char[] answer = new char[N];
    for(int i=N; i>=1; i--) {
      answer[i-1] = prev[i][life];
      if(prev[i][life] == 'L') {
        life += arr[i][1];
      }
    }

    System.out.println(new String(answer));
  }
}

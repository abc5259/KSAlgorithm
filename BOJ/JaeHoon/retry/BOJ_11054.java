package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11054 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp1 = new int[N];
    int[] dp2 = new int[N];

    for(int i=0; i<N; i++) {
      dp1[i] = 1;
      for(int j=i-1; j>=0; j--) {
        if(arr[i] > arr[j] && dp1[i] < dp1[j] + 1) {
          dp1[i] = dp1[j] + 1;
        }
      }
    }

    for(int i=N-1; i>=0; i--) {
      dp2[i] = 1;
      for(int j=i+1; j<N; j++) {
        if(arr[i] > arr[j] && dp2[i] < dp2[j] + 1) {
          dp2[i] = dp2[j] + 1;
        }
      }
    }
    int max = 0;
    for(int i=0; i<N; i++) {
      max = Math.max(max, dp1[i] + dp2[i] - 1);
    }
    System.out.println(max);
  }
}

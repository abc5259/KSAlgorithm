package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2565 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int[][] arr = new int[N][2];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr,(a,b)->a[0]-b[0]);

    int[] dp = new int[N];
    dp[0] = arr[0][1];
    int end = 0;
    for(int i=1; i<N; i++) {
      if(dp[end] < arr[i][1]) {
        dp[end+1] = arr[i][1];
        end++;
      }else {
        int idx = pos(end, dp, arr[i][1]);
        dp[idx] = arr[i][1];
      }
    }
  
    System.out.println(N - end - 1);
  }
  public static int pos(int end, int[] list, int target) {
    int low = 0;
    int high = end;

    while(low < high) {
      int mid = (low + high) / 2;

      if(target > list[mid]) {
        low = mid + 1;
      }else {
        high = mid;
      }
    }
  
    return low;
  }
}

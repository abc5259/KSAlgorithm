package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2304 {
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
    Arrays.sort(arr, (int[] a, int[] b) -> {
      return a[0] - b[0];
    });
    int[] prev = arr[0];
    int sum = 0;
    for(int i=1; i<N-1; i++) {
      int[] curr = arr[i];
      if(prev[1] < curr[1]) {
        sum += prev[1]*(curr[0]-prev[0]);
        prev = curr;
      }else {
        boolean isMaxHigth = true;
        for(int j=i+1; j<N; j++) {
          if(curr[1] < arr[j][1]) isMaxHigth = false;
        }
        if(isMaxHigth) {
          sum += curr[1]*(curr[0] - prev[0] - 1);
          sum += prev[1];
          prev = curr;
        }
      }
    }

    if(prev[1] < arr[N-1][1]) {
      sum += prev[1]*(arr[N-1][0] - prev[0]);
      sum += arr[N-1][1];
    }else {
      sum += arr[N-1][1]*(arr[N-1][0] - prev[0]);
      sum += prev[1];
    }
    System.out.println(sum);
  }
}

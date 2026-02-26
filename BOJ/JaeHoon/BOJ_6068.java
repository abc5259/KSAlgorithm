package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6068 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][2];
    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      arr[i][0] = t;
      arr[i][1] = s;
    }

    Arrays.sort(arr,(a,b) -> {
      // if(a[1] - a[0] == b[1] - b[0]) return a[1] - b[1];
      return a[1] - b[1];
    });

    int startTime = arr[0][1] - arr[0][0];
    int endTime = arr[0][1];
    if(startTime < 0) {
      System.out.println(-1);
      return;
    }
    for(int i=1; i<N; i++) {
      if(endTime + arr[i][0] <= arr[i][1]) {
        endTime += arr[i][0];
      }else {
        int needTime = endTime + arr[i][0] - arr[i][1];
        startTime -= needTime;
        endTime -= needTime;
        if(startTime < 0) {
          System.out.println(-1);
          return;
        }
        endTime = arr[i][1];
      }
    }

    System.out.println(startTime);
  }
}

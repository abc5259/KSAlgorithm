package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
  static int N,C;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    arr = new int[N];
    int low = Integer.MAX_VALUE;
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      if(i>1) low = Math.min(arr[i] - arr[i-1], low);
    }
    Arrays.sort(arr);
    int high = arr[N-1] - arr[0] + 1;
    
    while(low + 1 < high) {
      int mid = (low + high) / 2;
      if(check(mid)) {
        low = mid;
      }else {
        high = mid;
      }
    }
    System.out.println(low);
  }
  public static boolean check(int dif) {
    int installPos = arr[0];
    int cnt = 1;
    for(int i=1; i<N; i++) {
      if(arr[i] - installPos >= dif) {
        cnt++;
        installPos = arr[i];
      }
    }
    return cnt >= C;
  }
}

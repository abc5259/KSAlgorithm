package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13397 {
  static int[] arr;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    int low = 0;
    int high = 0;
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      high = Math.max(high, arr[i]);
    }

    while(low <= high) {
      int mid = (low + high) / 2;
      if(solve(mid) <= M) {
        high = mid - 1;
      }else {
        low = mid + 1;
      }
    }
    System.out.println(low);
  }
  static public int solve(int n) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int cnt = 1;
    for(int i=0; i<N; i++) {
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
      if(max - min > n) {
        i--;
        cnt++;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
      }
    }
    return cnt;
  }
}

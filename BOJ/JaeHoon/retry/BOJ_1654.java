package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
  static int K,N;
  static long[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new long[K];

    long low = 1;
    long high = Integer.MAX_VALUE;
    for(int i=0; i<K; i++) {
      arr[i] = Long.parseLong(br.readLine());
      high = Math.max(high, arr[i]);
    }
    high += 1;
    while(low + 1 < high) {
      long mid = (low + high) / 2;
      if(check(mid)) {
        low = mid;
      }else {
        high = mid;
      }
    }
    System.out.println(low);
  }
  public static boolean check(long n) {
    int sum = 0;
    for(int i=0; i<K; i++) {
      sum += arr[i] / n;
    }
    return sum >= N;
  }
}

package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300 {
  static int K;
  static long N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Long.parseLong(br.readLine());
    K = Integer.parseInt(br.readLine());

    long low = 0;
    long high = K;

    while(low + 1 < high) {
      long mid = (low + high) / 2;
      if(check(mid)) {
        high = mid;
      }else {
        low = mid;
      }
    }
    System.out.println(high);
  }
  public static boolean check(long target) {
    long sum = 0;
    for(int i=1; i<=N; i++) {
      long cnt = target / i ;
      if(cnt <= 0) continue;
      if(cnt >= N) {
        cnt = N;
      }
      sum += cnt;
    }
    return sum >= K;
  }
}

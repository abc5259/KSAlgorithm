package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300 {
  static int N,K;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    K = Integer.parseInt(br.readLine());

    long low = 1;
    long high = K + 1;

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
  public static boolean check(long target) {
    long sum = 0;
    for(int i=1; i<=N; i++) {
      long cnt = (target-1) / i ;
      if(cnt <= 0) continue;
      if(cnt >= N) {
        cnt = N;
      }
      sum += cnt;
    }
    return sum < K;
  }
}

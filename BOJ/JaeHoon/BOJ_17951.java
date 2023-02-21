package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17951 {
  static int N,K;
  static int[] exam;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    exam = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      exam[i] = Integer.parseInt(st.nextToken());
    }

    int low = 0;
    int high = 20 * 100000 + 1;

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
  public static boolean check(int max) {
    int cnt = 0;
    int sum = 0;
    for(int i=0; i<N; i++) {
      sum += exam[i];
      if(sum >= max) {
        cnt++;
        sum = 0;
      }
    }

    if(cnt < K) return false;

    return true;
  }
}

package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816 {
  static long[] A;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    A = new long[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      A[i] = Long.parseLong(st.nextToken());
    }
    Arrays.sort(A);


    StringBuffer sb = new StringBuffer();
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<M; i++) {
      long n = Long.parseLong(st.nextToken());
      int idx1 = lower(n);
      int idx2 = upper(n);
      if(A[idx2] == n)
        sb.append(idx2 - idx1 + 1).append(" ");
      else sb.append(0+" ");
    }
    System.out.println(sb);
  }
  public static int lower(long n) {
    int low = -1;
    int high = N;
    int mid;
    while(low + 1 < high) {
      mid = (low + high) / 2;
      if(n <= A[mid]) {
        high = mid;
      }else {
        low = mid;
      }
    }

    return high;
  }
  public static int upper(long n) {
    int low = 0;
    int high = N;
    int mid;
    while(low + 1 < high) {
      mid = (low + high) / 2;
      if(A[mid] <= n) {
        low = mid;
      }else {
        high = mid;
      }
    }

    return low;
  }
}

package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
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
      sb.append(solve(n)).append('\n');
    }
    System.out.println(sb);
  }
  public static int solve(long n) {
    int low = 0;
    int high = N;
    int mid;
    while(low + 1 < high) {
      mid = (low + high) / 2;
      if(n < A[mid]) {
        high = mid;
      }else {
        low = mid;
      }
    }

    return A[low] == n ? 1 : 0;
  }
}

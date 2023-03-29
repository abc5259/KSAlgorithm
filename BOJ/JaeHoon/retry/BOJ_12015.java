package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12015 {
  static int[] A;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {  
      A[i] = Integer.parseInt(st.nextToken());
    }

    int[] lis = new int[N];
    lis[0] = A[0];
    int end = 0;

    for(int i=1; i<N; i++) {
      if(lis[end] < A[i]) {
        lis[++end] = A[i];
      }else {
        int idx = pos(A[i], end, lis);
        lis[idx] = A[i];
      }
    }
    // System.out.println(Arrays.toString(lis));
    System.out.println(end + 1);
  }
  public static int pos(int target, int end, int[] lis) {
    int low = -1;
    int high = end;
    while(low + 1 < high) {
      int mid = (low + high) / 2;

      if(target <= lis[mid]) {
        high = mid;
      }else {
        low = mid;
      }
    }

    return high;
  }
}

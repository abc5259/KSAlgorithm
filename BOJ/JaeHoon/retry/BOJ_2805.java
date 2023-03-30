package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
  static int N,M;
  static int[] tree;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int low = 0;
    int high = 0;
    st = new StringTokenizer(br.readLine());
    tree = new int[N];
    for(int i=0; i<N; i++) {
      tree[i] = Integer.parseInt(st.nextToken());
      high = Math.max(high, tree[i]);
    }

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
  public static boolean check(int h) {
    long sum = 0;
    for (int t : tree) {
      if(t <= h) continue;
      sum += (t - h);
    }
    return sum >= M;
  }
}

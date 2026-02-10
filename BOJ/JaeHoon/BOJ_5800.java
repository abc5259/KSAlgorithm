package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5800 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    StringBuffer sb = new StringBuffer();
    int cnt = 1;
    while (K-- > 0) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int[] arr = new int[N];
      for(int i=0; i<N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr);
      int v = 0;
      for(int i=0; i<N-1; i++) {
        int dif = arr[i+1] - arr[i];
        v = Math.max(v, dif);
      }

      sb.append("Class ").append(cnt++).append('\n');
      sb.append("Max " + arr[N-1]).append(", Min " + arr[0]).append(", Largest gap " + v).append('\n');
    }
    System.out.print(sb);
  }
}

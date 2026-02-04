package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11501 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(st.nextToken());
    StringBuffer sb = new StringBuffer();
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int[] arr = new int[N];
      Queue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

      st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
        pq.offer(new int[]{i,arr[i]});
      }

      long result = 0;
      for(int i=0; i<N; i++) {
        while (!pq.isEmpty() && i >= pq.peek()[0]) {
          pq.poll();
        }
        if(!pq.isEmpty() && arr[i] < pq.peek()[1]) {
          result += pq.peek()[1] - arr[i];
        }
      }
      sb.append(result).append('\n');
    }
    System.out.println(sb);
  }
}

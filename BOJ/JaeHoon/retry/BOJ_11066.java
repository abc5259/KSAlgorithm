package BOJ.JaeHoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11066 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      Queue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
      for(int i=0; i<N; i++) {
        pq.offer(Integer.parseInt(st.nextToken()));
      }
      System.out.println(pq);
      int sum = 0;
      while (pq.size() >= 2) {
        int a = pq.poll();
        int b = pq.poll();
        sum += a + b;System.out.println(a + b);
        System.out.println(pq);
        pq.offer(a + b);
      }
      sb.append(sum).append('\n');
    }
    System.out.print(sb);
  }
}

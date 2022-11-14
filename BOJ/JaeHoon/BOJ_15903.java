package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    PriorityQueue<Long> pq = new PriorityQueue<>();
    for(int i=0; i<N; i++)
      pq.offer(Long.parseLong(st.nextToken()));
    
    for(int i=0; i<M; i++) {
      long x = pq.poll();
      long y = pq.poll();
      long sum = x + y;
      pq.offer(sum);
      pq.offer(sum);
    }
    long total = 0;
    while(!pq.isEmpty()) 
      total += pq.poll();
    System.out.println(total);
  } 
}

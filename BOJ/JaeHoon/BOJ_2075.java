package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        pq.offer(Integer.parseInt(st.nextToken()));
      }
    }
    for(int i=0; i<N-1; i++) {
      pq.poll();
    }
    System.out.println(pq.poll());
  }
}

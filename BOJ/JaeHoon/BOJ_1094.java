package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1094 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(br.readLine());
    int total = 64;
    Queue<Integer> pq = new PriorityQueue<>();
    pq.offer(64);
    while (total != X) {
      int min = pq.poll();
      int mm = min / 2;
      if(total - mm >= X) {
        total -= mm;
        pq.offer(mm);
      }else {
        pq.offer(mm);
        pq.offer(mm);
      }
    }

    System.out.println(pq.size());
  }
}

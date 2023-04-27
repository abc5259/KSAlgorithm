package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer(N);
    
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
      if(Math.abs(a) == Math.abs(b)) return a - b;
      return Math.abs(a) - Math.abs(b);
    });
    for(int i=0; i<N; i++) {
      int n = Integer.parseInt(br.readLine());
      if(n != 0) pq.offer(n);
      else {
        if(pq.isEmpty()) sb.append(0+"\n");
        else sb.append(pq.poll()+"\n");
      }
    }
    System.out.println(sb);

  }
}

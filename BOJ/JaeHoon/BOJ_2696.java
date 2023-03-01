package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2696 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();

    int T = Integer.parseInt(st.nextToken());
    for(int t=0; t<T; t++) {
      int M = Integer.parseInt(br.readLine());

      PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b) -> b - a);
      PriorityQueue<Integer> minPq = new PriorityQueue<>();

      st = new StringTokenizer(br.readLine());
      int size = M % 2 == 0 ? M/2 : M/2+1;
      sb.append(size+"\n");
      int cnt = 0;
      for(int i=1; i<=M; i++) {
        int n = Integer.parseInt(st.nextToken());

        if(maxPq.size() == minPq.size()) {
          maxPq.offer(n);
        }else {
          minPq.offer(n);
        }

        if(!minPq.isEmpty() && maxPq.peek() > minPq.peek()) {
          int max = maxPq.poll();
          int min = minPq.poll();
          maxPq.offer(min);
          minPq.offer(max);
        }
        
        if(i % 2 != 0) {
          cnt++;
          int mid = maxPq.peek();
          sb.append(mid+ " ");
          if(cnt % 10 == 0) sb.append("\n");
        }
        if(i % 10 == 0) {
          st = new StringTokenizer(br.readLine());
        }
      }
      sb.append('\n');
    }

    System.out.println(sb);
  }
}
 
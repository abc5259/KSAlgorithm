package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_24533 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    Queue<long[]> q = new LinkedList<>();
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      q.offer(new long[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
    }

    long[] prev = q.poll();
    long sum = 0;
    while(!q.isEmpty()) {
      long[] curr = q.poll();

      sum += prev[0] * curr[1] + prev[1] * curr[0];
      long[] newM = new long[]{prev[0]+curr[0],prev[1]+curr[1]};

      prev = newM;
    }

    System.out.println(sum);
  }
}

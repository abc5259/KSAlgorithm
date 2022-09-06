package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1826 {
  static int N,L,P;
  static GasStation[] gasStations;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); //주유소의 개수
    PriorityQueue<GasStation> info = new PriorityQueue<>();
    gasStations = new GasStation[N];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      info.offer(new GasStation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());
    int answer = 0;

    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

    //  현재 기름의 양으로 갈 수 있는 주유소만 q에 넣는데 갈 수 있는 주유소중에서 가장 큰 양을 주는 주유소 먼저 큐에 저장한다.
    // 만약 q가 비었다면 갈 수 있는 주유소가 없다는 뜻이므로 -1을 리턴한다.
    while(P < L) {
      while(!info.isEmpty() && P >= info.peek().dist) {
        GasStation curr = info.poll();
        q.offer(curr.weight);
      }
      if(q.isEmpty()) {
        answer = -1;
        break;
      }
      P = P + q.poll();
      answer++;
    }
    System.out.println(answer);
  }
  public static class GasStation implements Comparable<GasStation>{
    int dist,weight;
    GasStation(int dist, int weight) {
      this.dist = dist;
      this.weight = weight;
    }
    @Override
    public int compareTo(GasStation o) {
      return this.dist - o.dist;
    }

  }
}

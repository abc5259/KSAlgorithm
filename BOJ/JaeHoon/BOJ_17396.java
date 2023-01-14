package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17396 {
  static class Node {
    int idx;
    long cost;
    Node(int idx, long cost) {
      this.idx = idx;
      this.cost = cost;
    }
  }
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  static int[] see;
  static long[] dist;
  static int N,M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    see = new int[N];
    dist = new long[N];
    Arrays.fill(dist, Long.MAX_VALUE);
    for(int i=0; i<N; i++) {
      graph.add(new ArrayList<>());
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      see[i] = Integer.parseInt(st.nextToken());
    }
    
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      graph.get(v1).add(new Node(v2, cost));
      graph.get(v2).add(new Node(v1, cost));
    }
    solve();
    System.out.println(dist[N-1] == Long.MAX_VALUE ? -1 : dist[N-1]);
  }
  public static void solve() {
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Long.compare(a.cost, b.cost));
    pq.offer(new Node(0, 0));
    dist[0] = 0;

    while(!pq.isEmpty()) {
      Node curr = pq.poll();

      if(dist[curr.idx] < curr.cost) continue;
      
      for(Node next:graph.get(curr.idx)) {
        if(next.idx != N-1 && see[next.idx] == 1) continue;
        if(dist[next.idx] > curr.cost + next.cost) {
          dist[next.idx] = curr.cost + next.cost;
          pq.offer(new Node(next.idx, dist[next.idx]));
        }
      }
    }
  }
}

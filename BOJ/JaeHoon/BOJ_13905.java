package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13905 {
  static class Node {
    int idx;
    long cost;
    Node(int idx, long cost) {
      this.idx = idx;
      this.cost = cost;
    }
  }
  static long[] dist;
  static boolean[] isVisit;
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Function<String,Integer> f = Integer::parseInt;
    int N = f.apply(st.nextToken());
    int M = f.apply(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int s = f.apply(st.nextToken());
    int e = f.apply(st.nextToken());

    dist = new long[N+1];
    isVisit = new boolean[N+1];
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
      dist[i] = -1;
    } 
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = f.apply(st.nextToken());
      int v2 = f.apply(st.nextToken());
      int cost = f.apply(st.nextToken());
      graph.get(v1).add(new Node(v2, cost));
      graph.get(v2).add(new Node(v1, cost));
    }
    solve(s);
    // System.out.println(Arrays.toString(dist));
    System.out.println(dist[e] == -1 ? 0 : dist[e]);
  }
  public static void solve(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Long.compare(b.cost, a.cost));
    pq.offer(new Node(start, Long.MAX_VALUE));
    dist[start] = 0;

    while(!pq.isEmpty()) {
      Node curr = pq.poll();

      isVisit[curr.idx] = true;

      for(Node next: graph.get(curr.idx)) {
        if(!isVisit[next.idx] && dist[next.idx] < Math.min(curr.cost, next.cost)) {
          dist[next.idx] = Math.min(curr.cost, next.cost);
          pq.offer(new Node(next.idx, dist[next.idx]));
        }
      }
    }
  }

}

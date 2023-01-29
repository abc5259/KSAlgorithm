package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14284 {
  static class Node {
    int v,w;
    Node(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }
  static int N,M,S,T;
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph.get(v1).add(new Node(v2, w));
      graph.get(v2).add(new Node(v1, w));
    }

    st = new StringTokenizer(br.readLine());
    S = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    System.out.println(solve());
  }

  public static int solve() {
    int[] dist = new int[N+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[S] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
    pq.offer(new Node(S, 0));

    while(!pq.isEmpty()) {
      Node curr = pq.poll();

      if(dist[curr.v] < curr.w) continue;

      for(Node next: graph.get(curr.v)) {
        if(dist[next.v] > curr.w + next.w) {
          dist[next.v] = curr.w + next.w;
          pq.offer(new Node(next.v, dist[next.v]));
        }
      }
    }

    return dist[T];
  }
}

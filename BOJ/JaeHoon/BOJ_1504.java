package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
  static class Node implements Comparable<Node>{
    int v,cost;
    Node(int v, int cost) {
      this.v = v;
      this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }
  static int[] dist;
  static boolean[] check;
  static int INF = 200000000;
  static ArrayList<ArrayList<Node>> graph;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    dist = new int[N+1];
    check = new boolean[N+1];
    graph = new ArrayList<>();
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    for(int i=1; i<=E; i++) {
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      graph.get(n1).add(new Node(n2, cost));
      graph.get(n2).add(new Node(n1, cost));
    }
    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    // 1 -> v1 -> v2 -> N
    int dist1 = 0;
    dist1 += dijkstra(1, v1);
    dist1 += dijkstra(v1, v2);
    dist1 += dijkstra(v2, N);

    // 1 -> v2 -> v1 -> N
    int dist2 = 0;
    dist2 += dijkstra(1, v2);
    dist2 += dijkstra(v2, v1);
    dist2 += dijkstra(v1, N);

    int result = dist1 > INF && dist2 > INF ? -1 : dist1 < dist2 ? dist1 : dist2;
    System.out.println(result);
  }
  public static int dijkstra(int start, int end) {
    Arrays.fill(dist, INF);
    Arrays.fill(check, false);

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));
    dist[start] = 0;

    while(!pq.isEmpty()) {
      Node curr = pq.poll();

      if(!check[curr.v]) {
        check[curr.v] = true;
        for(Node node: graph.get(curr.v)) {
          if(!check[node.v] && dist[node.v] > dist[curr.v] + node.cost) {
            dist[node.v] = dist[curr.v] + node.cost;
            pq.offer(new Node(node.v, dist[node.v]));
          }
        }
      }
    }
    return dist[end];
  }
}

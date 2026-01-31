package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5972 {
  static class Node {
      int v,w;
      public Node(int v, int w) {
        this.v=v;
        this.w=w;
      }
  }
  static List<List<Node>> graph = new ArrayList<>();
  static int N, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }

    System.out.println(solve());
  }

  public static int solve() {
    int[] dist = new int[N+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    Queue<Node> q = new PriorityQueue<>((a,b) -> a.w - b.w);
    q.offer(new Node(1, 0));
    dist[1] = 0;

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if(cur.w > dist[cur.v]) continue;

      for(Node next: graph.get(cur.v)) {
        if(next.w + cur.w < dist[next.v]) {
          dist[next.v] = next.w + cur.w;
          q.offer(new Node(next.v, dist[next.v]));
        }
      }
    }

    return dist[N];
  }
}

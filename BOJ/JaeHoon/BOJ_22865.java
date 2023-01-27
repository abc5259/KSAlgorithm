package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22865 {
  static class Node {
    int v,w;
    Node(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }
  static int N,M;
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  static int[] friend = new int[3];
  static int answer;
  static ArrayList<int[]> dists = new ArrayList<>(3);
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<3; i++) {
      friend[i] = Integer.parseInt(st.nextToken());
    }
    M = Integer.parseInt(br.readLine());
    for(int i=1; i<=M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph.get(v1).add(new Node(v2, w));
      graph.get(v2).add(new Node(v1, w));
    }

    for(int i=0; i<3; i++) {
      dijkstra(friend[i]);
    }
    int max = Integer.MIN_VALUE;
    int answer = 1; 
    for(int i=1; i<=N; i++) {
      int a = dists.get(0)[i];
      int b = dists.get(1)[i];
      int c = dists.get(2)[i];

      int small = Math.min(a, Math.min(b, c));
      if(small > max) {
        max = small;
        answer = i;
      }
    }
    System.out.println(answer);
  }
  public static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
    int[] dist = new int[N+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
    pq.offer(new Node(start, 0));
    while(!pq.isEmpty()) {
      Node curr = pq.poll();

      if (dist[curr.v] < curr.w) {
				continue;
			}

      for(Node next:graph.get(curr.v)) {
        if(dist[next.v] > curr.w + next.w) {
          dist[next.v] = curr.w + next.w;
          pq.offer(new Node(next.v, dist[next.v]));
        }
      }
    }

    dists.add(dist);
  }
}

package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6497 {
  static class Edge implements Comparable<Edge>{
    int v,w;
    Edge(int v, int w) {
      this.v = v;
      this.w = w;
    }
    @Override
    public int compareTo(Edge o) {
      return this.w - o.w;
    }
  }
  static ArrayList<ArrayList<Edge>> graph;
  static boolean[] isVisit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();
    while(true) {
      st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      if(m == 0 && n == 0) break;
      graph = new ArrayList<>();
      isVisit = new boolean[m];
      int total = 0;
      for(int i=0; i<m; i++) {
        graph.add(new ArrayList<>());
      }
      for(int i=0; i<n; i++) {
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        total += w;
        graph.get(v1).add(new Edge(v2, w));
        graph.get(v2).add(new Edge(v1, w));
      }

      int sum = prim();
      sb.append(total - sum).append("\n");
    }
    System.out.println(sb);
  }
  public static int prim() {
    PriorityQueue<Edge> q = new PriorityQueue<>();
    isVisit[0] = true;
    int sum = 0;
    for(Edge e: graph.get(0)) {
      q.offer(e);
    }
    while(!q.isEmpty()) {
      Edge curr = q.poll();
      if(!isVisit[curr.v]) {
        sum += curr.w;
        isVisit[curr.v] = true;
        for(Edge next: graph.get(curr.v)) {
          if(!isVisit[next.v]) q.offer(next);
        }
      }
    }
    return sum;
  }
}


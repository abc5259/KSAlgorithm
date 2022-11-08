package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865 {
  static class Edge {
    int v, w;
    Edge(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }
  static ArrayList<ArrayList<Edge>> graph;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int T = Integer.parseInt(st.nextToken());
    for(int t=0; t<T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int W = Integer.parseInt(st.nextToken());
      graph = new ArrayList<>();
      for(int i=0; i<=N; i++) 
        graph.add(new ArrayList<>());
      for(int i=0; i<M; i++) {
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        graph.get(v1).add(new Edge(v2, w));
        graph.get(v2).add(new Edge(v1, w));
      }
      for(int i=0; i<W; i++) {
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        graph.get(v1).add(new Edge(v2, -w));
      }

      boolean isCycle = false;
      for(int i=1; i<=N; i++) {
        if(bellmanford(i)) {
          isCycle = true;
          sb.append("YES\n");
          break;
        }
      }
      if(!isCycle) 
        sb.append("NO\n");
      
    }
    System.out.println(sb);
  }
  public static boolean bellmanford(int start) {
    int[] dist = new int[N+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
    boolean update = false;
    for(int i=0; i<N-1; i++) {
      update = false;
      for(int j=1; j<=N; j++) {
        for(Edge e: graph.get(j)) {
          if(dist[j] != Integer.MAX_VALUE && dist[e.v] > dist[j] + e.w) {
            dist[e.v] = dist[j] + e.w;
            update = true;
          }
        }
      }
      if(!update) break;
    }
    if(update) {
      for(int j=1; j<=N; j++) {
        for(Edge e: graph.get(j)) {
          if(dist[j] != Integer.MAX_VALUE && dist[e.v] > dist[j] + e.w) {
            return true;
          }
        }
      }
    }
    return false;
  }
}

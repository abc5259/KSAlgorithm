package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_199976 {
  public static class Edge {
    int v;
    int cost;
    Edge(int v, int cost) {
      this.v = v;
      this.cost = cost;
    }
  }
  public static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
  public static boolean[] isVisit;
  public static int maxCost = 0;
  public static int result = 0;
  public static int node;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    isVisit = new boolean[N+1];
    for(int i=0;i <=N; i++) {
      graph.add(new ArrayList<>());
    }
    for(int i=1; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      graph.get(v1).add(new Edge(v2, cost));
      graph.get(v2).add(new Edge(v1, cost));
    }
    dfs(1,0);
    isVisit = new boolean[N+1];
    dfs(node,0);
    System.out.println(maxCost);
  }
  public static void dfs(int start,int cost) {
    if(maxCost < cost) {
      maxCost = cost;
      node = start;
    }
    isVisit[start] = true;
    for(Edge next: graph.get(start)) {
      if(!isVisit[next.v]) {
        dfs(next.v, cost + next.cost);
      }
    }
  }
}

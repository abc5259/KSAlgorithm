package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1167 {
  public static class Edge {
    int weight;
    int v;
    Edge(int weight, int v) {
      this.weight = weight;
      this.v = v;
    }
  }
  public static ArrayList<ArrayList<Edge>> map;
  public static boolean[] isVisit;
  public static int max = Integer.MIN_VALUE;
  public static int maxEdge;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    map = new ArrayList<>();
    isVisit = new boolean[V+1];
    for(int i=0; i<=V; i++) {
      map.add(new ArrayList<>());
    }
    for(int i=1; i<=V; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2;
      while((v2 = Integer.parseInt(st.nextToken())) != -1) {
        int w = Integer.parseInt(st.nextToken());
        map.get(v1).add(new Edge(w, v2));
      } 
    }
    dfs(1, 0);
    dfs(maxEdge, 0);
    System.out.println(max);
  }
  public static void dfs(int start,int weight) {
    if(max < weight) {
      max = weight;
      maxEdge = start;
    }
    isVisit[start] = true;
    for(Edge edge: map.get(start)) {
      if(!isVisit[edge.v]) {
        dfs(edge.v, weight+edge.weight);
      }
    }
  }
}

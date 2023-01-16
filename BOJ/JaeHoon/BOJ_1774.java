package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1774 {
  static class Edge{
    int u,v;
    double cost;
    Edge(int u,int v, double cost) {
      this.u = u;
      this.v = v;
      this.cost = cost;
    }
  }
  static class Point {
    int x,y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    ArrayList<Edge> edges = new ArrayList<>();
    Point[] points = new Point[N+1];
    int[] parent = new int[N+1];
    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    for(int i=1; i<=N-1; i++) {
      for(int j=i+1; j<=N; j++) {
        edges.add(new Edge(i, j, cost(points[i], points[j])));
      }
    }
    for(int i=1; i<=N; i++) {
      parent[i] = i;
    }
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      union(v1,v2,parent);
    }
    Collections.sort(edges,(a,b) -> Double.compare(a.cost, b.cost));
    double answer = 0;
    for(int i=0; i<edges.size(); i++) {
      Edge edge = edges.get(i);

      if(find(parent, edge.u) != find(parent, edge.v)) {
        union(edge.u, edge.v, parent);
        answer += edge.cost;
      }
    }
    System.out.printf("%.2f\n",answer);
  }
  public static double cost(Point a, Point b) {
    return Math.sqrt(Math.pow(Math.abs(a.x - b.x), 2) + Math.pow(Math.abs(a.y - b.y), 2));
  }
  public static int find(int[] parent, int i) {
    if(parent[i] == i) return i;
    return parent[i] = find(parent, parent[i]);
  }
  public static void union(int a, int b, int[] parent) {
    int a_parent = find(parent, a);
    int b_parent = find(parent, b);
    if(a_parent <= b_parent) 
      parent[b_parent] = a_parent;
    else
      parent[a_parent] = b_parent;
  }
}

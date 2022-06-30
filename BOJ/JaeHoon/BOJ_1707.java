package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707 {
  static ArrayList<ArrayList<Integer>> graph;
  static boolean[] isVisit;
  static boolean[] color;
  static StringBuffer sb = new StringBuffer();
  static boolean isCheck;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());
    for(int i=0; i<K; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      graph = new ArrayList<>();
      isVisit = new boolean[V+1];
      color = new boolean[V+1];
      isCheck = true;
      for(int j=0; j<=V; j++) 
        graph.add(new ArrayList<>());
      for(int j=0; j<E; j++) {
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
      }
      for(int j=1; j<=V; j++) {
        if(!isVisit[j])
          bfs(V,j);
      }
      sb.append(isCheck ? "YES" : "NO").append('\n');
    }
    System.out.println(sb);
  }
  public static void bfs(int N,int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    isVisit[start] = true;
    color[start] = true;
    while(!queue.isEmpty() && isCheck) {
      int v = queue.poll();
      boolean v1Color = color[v];
      for(int item:graph.get(v)) {
        if(!isVisit[item]) {
          queue.offer(item);
          isVisit[item] = true;
          color[item] = !v1Color;
        }
        else if(isVisit[item] && color[item] == v1Color) {
          isCheck = false;
          return;
        }
      }
    }
  }
}

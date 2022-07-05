package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16947 {
  static ArrayList<ArrayList<Integer>> graph;
  static boolean[] isVisit;
  static boolean[] cycle;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    StringBuffer sb = new StringBuffer();
    graph = new ArrayList<>();
    isVisit = new boolean[N+1];
    cycle = new boolean[N+1];
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }
    for(int i=1; i<=N; i++) {
      if(isCycle(i,i,i)) break;
      cycle = new boolean[N+1];
    }
    for(int i=1; i<=N; i++) {
      if(!cycle[i]) {
        sb.append(bfs(i)).append(' ');
        isVisit = new boolean[N+1];
      }else {
        sb.append(0).append(' ');
      }
    }
    System.out.println(sb);
  }
  public static boolean isCycle(int prev,int node,int start) {
    cycle[node] = true;
    for(int V: graph.get(node)) {
      if(!cycle[V]) {
        if(isCycle(node,V,start)) return true;
      }
      else if(V != prev && V == start) {
        return true;
      }
    }
    cycle[node] = false;
    return false;
  }
  public static int bfs(int start) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(start,0));
    isVisit[start] = true;
    int count = 0;
    while(!queue.isEmpty()) {
      Node node = queue.poll();
      for(int V: graph.get(node.node)) {
        Node next = new Node(V, node.count+1);
        if(cycle[V]) {
          count = next.count;
          break;
        }
        else if(!isVisit[V]) {
          queue.offer(next);
          isVisit[V] = true;
        }
      }
    }
    return count;
  }
  public static class Node {
    int count;
    int node;
    Node(int node,int count) {
      this.count = count;
      this.node = node;
    }
  }
}

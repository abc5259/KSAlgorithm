package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939 {
  static int answer = Integer.MIN_VALUE;
  static ArrayList<ArrayList<Node>> graph;
  static boolean[] isVisit;
  static int start,end,N;
  static class Node {
    int v,w;
    Node(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();

    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph.get(v1).add(new Node(v2, w));
      graph.get(v2).add(new Node(v1, w));
      low = Math.min(low, w);
      high = Math.max(high, w);
    }
    st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
  
    while(low <= high) {
      int middle = (low + high) / 2;
      if(bfs(middle)) {
        low = middle + 1;
        answer = middle;
      }
      else high = middle - 1;
    }
    System.out.println(answer);
    
  }
  public static boolean bfs(int weight) {
    Queue<Node> q = new LinkedList<>();
    isVisit = new boolean[N+1];
    q.offer(new Node(start, 0));
    while(!q.isEmpty()) {
      Node curr = q.poll();
      if(curr.v == end) return true;
      for(Node next: graph.get(curr.v)) {
        if(weight <= next.w && !isVisit[next.v]) {
          isVisit[next.v] = true;
          q.offer(next);
        }
      }
    }
    return false;
  }
}

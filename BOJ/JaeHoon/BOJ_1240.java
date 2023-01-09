package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1240 {
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  static int N;
  static boolean[] isVisit;
  static class Node {
    int w,v;
    Node(int v,int w) {
      this.v = v;
      this.w = w;
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    for(int i=1; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph.get(v1).add(new Node(v2, w));
      graph.get(v2).add(new Node(v1, w));
    }
    StringBuffer sb = new StringBuffer(M);
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      isVisit = new boolean[N+1];
      sb.append(dfs(v1, v2, 0)).append('\n');
    }
    System.out.println(sb);
  }

  public static int dfs(int start, int end, int d) {
    isVisit[start] = true;
    if(start == end) {
      return d;
    }
    for(Node next:graph.get(start)) {
      if(!isVisit[next.v]) {
        int n = dfs(next.v, end, d + next.w);
        if(n != -1) return n;
      }
    }
    return -1;
  }
}

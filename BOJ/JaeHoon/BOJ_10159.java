package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10159 {
  static ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
  static ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    for(int i=0; i<=N; i++) {
      graph1.add(new ArrayList<>());
      graph2.add(new ArrayList<>());
    }

    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph1.get(v1).add(v2);
      graph2.get(v2).add(v1);
    }
    StringBuffer sb = new StringBuffer();
    for(int i=1; i<=N; i++) {
      int sum = N - 1;
      sum -= bfs(i,N,graph1);
      sum -= bfs(i,N,graph2);
      sb.append(sum).append('\n');
    }
    System.out.println(sb);
  }
  static public int bfs(int node,int N, ArrayList<ArrayList<Integer>> graph) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] isVisit = new boolean[N+1];
    q.offer(node);
    isVisit[node] = true;
    int sum = 0;
    while(!q.isEmpty()) {
      int curr = q.poll();
      for(int next:graph.get(curr)) {
        if(isVisit[next]) continue;
        sum++;
        isVisit[next] = true;
        q.offer(next);
      }
    }
    return sum;
  }
}

package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
  static int[][] graph;
  static boolean[] isVisit;
  static boolean[] isVisit2;
  static int N;
  static StringBuffer sb = new StringBuffer();
  static int[] arr;
  static Queue<Integer> queue;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());
    graph = new int[N+1][N+1];
    isVisit = new boolean[N+1];
    isVisit2 = new boolean[N+1];
    queue = new LinkedList<>();
    arr = new int[N];
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a][b] = 1;
      graph[b][a] = 1;
    }
    isVisit2[V] = true;
    dfs(1, V);
    sb.append('\n');
    bfs(V);
    System.out.println(sb);
  }
  public static void dfs(int depth,int start) {
    isVisit[start] = true;
    sb.append(start).append(" ");
    for(int i=1; i<=N; i++) {
      if(graph[start][i] == 1 && !isVisit[i]) {
        dfs(depth+1, i);
      }
    }
  }
  public static void bfs(int start) {
    queue.offer(start);
    while(!queue.isEmpty()) {
      int node = queue.poll();
      sb.append(node).append(" ");
      for(int i=1; i<=N; i++) { 
        if(!isVisit2[i] && graph[node][i] == 1) {
          isVisit2[i] = true;
          queue.offer(i);
        }
      }
    }
  }
}

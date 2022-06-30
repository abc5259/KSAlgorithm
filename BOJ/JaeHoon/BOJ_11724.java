package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {
  static ArrayList<ArrayList<Integer>> graph;
  static boolean[] isVisit;
  static int result = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    isVisit = new boolean[N+1];
    graph = new ArrayList<>();
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    for(int j=0; j<M; j++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }
    for(int i=1; i<=N; i++) {
      if(!isVisit[i]) {
        dfs(0, i, N);
        result++;
      }
    }
    System.out.println(result);
  }
  public static void dfs(int depth,int start,int N) {
    if(depth == N) {
      System.out.println(1);
      System.exit(0);
    }
    isVisit[start] = true;
    for(int v: graph.get(start)) {
      if(!isVisit[v])
      dfs(depth+1,v,N);
    }
  }
}

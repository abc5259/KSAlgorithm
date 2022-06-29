package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {
  static ArrayList<ArrayList<Integer>> graph;
  static boolean[] isVisit;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();
    isVisit = new boolean[N];
    for(int i=0; i<N; i++) {
      graph.add(new ArrayList<>());
    }
    for(int j=0; j<M; j++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    for(int i=0; i<N; i++) {
      dfs(0,i);
    }
    System.out.println(0);
  }
  public static void dfs(int depth,int idx) {
    if(depth == 5) {
      System.out.println(1);
      System.exit(0);
      return;
    }
    for(int node: graph.get(idx)) {
      if(!isVisit[node]) {
        isVisit[node] = true;
        dfs(depth+1, node);
        isVisit[node] = false;
      }
    }
  }
}

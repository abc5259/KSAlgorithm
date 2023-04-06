package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24479 {
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean[] isVisited;
  static int[] result;
  static int N,M,R;
  static StringBuffer sb = new StringBuffer();
  static int cnt = 1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    
    isVisited = new boolean[N+1];
    result = new int[N+1];
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    for(int i=1; i<=M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }

    for(int i=0; i<=N; i++) {
      Collections.sort(graph.get(i));
    }


    
    isVisited[R] = true;
    dfs(1, R);
    for(int i=1; i<=N; i++) {
      sb.append(result[i]+"\n");
    }
    System.out.println(sb);
  }
  public static void dfs(int depth, int v) {
    result[v] = cnt++;
    for (int next: graph.get(v)) {
      if(!isVisited[next]) {
        
        isVisited[next] = true;
        dfs(depth, next);
      }
    }
  }
}

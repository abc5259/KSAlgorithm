package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14621 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] graph = new int[M][3];
    int[] parent = new int[N+1];
    char[] wm = new char[N+1];
    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; i++) {
      wm[i] = st.nextToken().charAt(0);
      parent[i] = i;
    }
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      graph[i][0] = v1;
      graph[i][1] = v2;
      graph[i][2] = cost;
    }

    Arrays.sort(graph,(a,b) -> a[2] - b[2]);
    int sum = 0;
    int length =0;
    for(int i=0; i<M; i++) {
      if(wm[graph[i][0]] == wm[graph[i][1]]) continue;
      if(find(parent, graph[i][0]) != find(parent, graph[i][1])) {
        union(graph[i][0], graph[i][1], parent);
        sum += graph[i][2];
        length++;
      }
    }
    System.out.println(length != N-1 ? - 1 : sum);
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

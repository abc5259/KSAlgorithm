package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_16964 {
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean[] isVisit;
  static int[] arr;  
  static int offset = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    isVisit = new boolean[N+1];
    arr = new int[N];
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    for(int i=0; i<N-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    System.out.println(dfs(1,N,1) ? 1 : 0);
  }
  public static boolean dfs(int start,int N,int depth) {
    isVisit[start] = true;
    offset++;
    if(offset == N) {
      return true;
    }
    HashSet<Integer> set = new HashSet<>();
    for(int V: graph.get(start)) {
      if(!isVisit[V]) {
        set.add(V);
      }
    }
    int size = set.size();
    for(int i=0; i<size; i++) {
      if(set.contains(arr[offset])) {
        if(dfs(arr[offset],N,depth+1)) return true;
      }
    }
    return false;
  }
}

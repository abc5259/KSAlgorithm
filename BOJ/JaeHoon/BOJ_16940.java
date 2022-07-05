package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_16940 {
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static boolean[] isVisit;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    for(int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }
    for(int i=0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph.get(v1).add(v2);
      graph.get(v2).add(v1);
    }
    arr = new int[N];
    isVisit = new boolean[N+1];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    System.out.println(bfs(1) ? 1 : 0);
  }
  public static boolean bfs(int start) {
    if(start != arr[0]) return false;
    Queue<Integer> queue = new LinkedList<>();
    HashSet<Integer> set = new HashSet<>();
    isVisit[start] = true;
    int offset = 1;
    queue.offer(start);
    while(!queue.isEmpty()) {
      set.clear();
      int node = queue.poll();
      for(int V: graph.get(node)) {
        if(!isVisit[V]) {
          isVisit[V] = true;
          set.add(V);
        }
      }
      int size = set.size();
      for(int i=0; i<size; i++) {
        if(set.contains(arr[offset+i])) queue.offer(arr[offset+i]);
        else return false;
      }
      offset += size;
    }
    return true;
  }
}

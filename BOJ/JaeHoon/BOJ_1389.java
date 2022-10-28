package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int N,M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
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
    int index = 1;
    int min = Integer.MAX_VALUE;
    for(int i=1; i<=N; i++) {
      int total = bfs(i);
      if(min > total) {
        min = total;
        index = i;
      }
    }
    System.out.println(index);
  }
  static public int bfs(int start) {
    Queue<int[]> q = new LinkedList<>();
    int[] dist = new int[N+1];
    Arrays.fill(dist, -1);
    q.offer(new int[] {start,0});
    while(!q.isEmpty()) {
      int[] curr = q.poll();
      for(int next:graph.get(curr[0])) {
        if(next == start) continue;
        if(dist[next] == -1) {
          dist[next] = curr[1] + 1;
          q.offer(new int[]{next,dist[next]});
        }
      }
    }
    int sum = 0;
    for(int i=1; i<=N; i++) {
      if(i == start) continue;
      sum += dist[i];
    }
    // System.out.println(Arrays.toString(dist));
    return sum;
  }
}

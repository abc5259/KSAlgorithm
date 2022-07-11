package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725 {
  static int[] result;
  static boolean[] isVisit;
  static ArrayList<ArrayList<Integer>> map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int N = Integer.parseInt(st.nextToken());
    map = new ArrayList<>();
    result = new int[N+1];
    isVisit = new boolean[N+1];
    for(int i=0; i<=N; i++) {
      map.add(new ArrayList<>());
    }
    for(int i=0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      map.get(v1).add(v2);
      map.get(v2).add(v1);
    }
    bfs(1);
    for(int i=2; i<=N; i++) {
      sb.append(result[i]).append('\n');
    }
    System.out.println(sb);
  }
  public static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    isVisit[start] = true;
    while(!queue.isEmpty()) {
      int now = queue.poll();
      for(int next: map.get(now)) {
        if(!isVisit[next]) {
          queue.offer(next);
          result[next] = now;
          isVisit[next] = true;
        }
      }
    }
  }
}

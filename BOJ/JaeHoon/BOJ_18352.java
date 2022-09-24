package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352 {
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static StringBuffer sb = new StringBuffer();
  static boolean[] isVisit;
  static ArrayList<Integer> answer = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    isVisit = new boolean[N+1];
    for(int i=0; i<=N; i++) 
      graph.add(new ArrayList<>());

    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph.get(v1).add(v2);
    }
    bfs(X,K);
    Collections.sort(answer);
    for(int i=0; i<answer.size(); i++)
      sb.append(answer.get(i)).append('\n');
    System.out.println(answer.size() > 0 ? sb : -1);
  }
  static public void bfs(int start, int k) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{start,0});
    isVisit[start] = true;
    while(!q.isEmpty()) {
      int[] curr = q.poll();
      if(k == curr[1]) {
        answer.add(curr[0]);
      }
      else {
        for(int next: graph.get(curr[0])) {
          if(isVisit[next]) continue;
          isVisit[next] = true;
          q.offer(new int[]{next,curr[1] + 1});
        }
      }
    }
  }
}

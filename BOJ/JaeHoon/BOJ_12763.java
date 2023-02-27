package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_12763 {
  static class Node {
    int v,time,money;
    Node(int v, int time, int money) {
      this.v = v;
      this.time = time;
      this.money = money;
    }
  }
  static int N,T,M;
  static int[] cost;
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    
    for(int i=0; i<=N; i++){
      graph.add(new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine());
    T = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int L = Integer.parseInt(br.readLine());
    for(int i=1; i<=L; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      int money = Integer.parseInt(st.nextToken());

      graph.get(v1).add(new Node(v2, time, money));
      graph.get(v2).add(new Node(v1, time, money));
    }
    cost = new int[N+1];
    Arrays.fill(cost, Integer.MAX_VALUE);
    dfs(0, 0, 1);
    System.out.println(cost[N] == Integer.MAX_VALUE ? -1 : cost[N]);
  }

  public static boolean dfs(int money, int time, int idx) {
    if(idx == N) return true;
    boolean result = false;
    for(Node next: graph.get(idx)) {
      int nextTime = next.time + time;
      int nextMoney = next.money + money;

      if(nextTime > T || nextMoney > M) continue;
      result = dfs(nextMoney, nextTime, next.v);

      if(result) {
        cost[next.v] = Math.min(cost[next.v], nextMoney);
      }

    }

    return true;
  }

  public static int solve(int start, int end) {

    int[][] dist = new int[N+1][10001];
    for(int i=0; i<=N; i++) 
      Arrays.fill(dist[i], Integer.MAX_VALUE);

    dist[start][0] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
    pq.offer(new Node(start, 0, 0));

    while(!pq.isEmpty()) {
      Node curr = pq.poll();

      if(dist[curr.v][curr.money] < curr.time) continue;

      for(Node next: graph.get(curr.v)) {
        int nextCost = curr.money + next.money;
        if(nextCost > M) continue;
        if(dist[next.v][nextCost] > curr.time + next.time) {
          if(curr.time + next.time > T) continue;
          dist[next.v][nextCost] = curr.time + next.time;
          pq.offer(new Node(next.v, dist[next.v][nextCost], nextCost));
        }
      }
    }
    for(int i=0; i<=M; i++) {
      if(dist[N][i] <= T) {
        return i;
      }
    }
    return -1;
  }
}
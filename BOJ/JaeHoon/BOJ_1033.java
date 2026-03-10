package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1033 {

  static class Node {
    int v, p, q;
    public Node(int v, int p, int q) {
      this.v = v;
      this.p = p;
      this.q = q;
    }
  }
  static List<List<Node>> graph = new ArrayList<>();
  static int N;
  static long[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    for(int i=0; i<N; i++) {
      graph.add(new ArrayList<>());
    }

    long lcm = 1;
    arr = new long[N];
    for(int i=0; i<N-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Node(b, p, q));
      graph.get(b).add(new Node(a, q, p));

      lcm *= lcm(p,q);
    }
    
    arr[0] = lcm;

    bfs(0);

    long gcd = arr[0];
    for(int i=1; i<N; i++) {
      gcd = gcd(gcd, arr[i]);
    }
    
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<N; i++) {
      arr[i] /= gcd;
      sb.append(arr[i]).append(" ");
    }
    System.out.println(sb);
  }

  static void bfs(int start) {
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(start);
    boolean[] visited = new boolean[N];
    visited[start] = true;

    while (!q.isEmpty()) {
      int c = q.poll();
      // System.out.println(c);
      for(Node next: graph.get(c)) {
        if(visited[next.v]) continue;
        arr[next.v] = (arr[c] * next.q) / next.p;
        visited[next.v] = true;
        q.offer(next.v);
      }
    }
  }

  static long lcm(long a, long b) {
    return (a / gcd(a, b)) * b;
  }

  static long gcd(long a, long b) {
    if(b==0) {
      return a;
    }
    return gcd(b, a%b);
  }
}

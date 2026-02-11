package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1068 {
  static class Node {
    int p;
    int v;
    public Node(int p, int v) {
      this.p = p;
      this.v = v;
    }
  }
  static int N;
  static Node[] nodes;
  static int result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    nodes = new Node[N];
    st = new StringTokenizer(br.readLine());
    Node root = null;
    for(int i=0; i<N; i++) {
      int p = Integer.parseInt(st.nextToken());
      nodes[i] = new Node(p, i);
      if(p == -1) root = nodes[i];
    }

    int removeV = Integer.parseInt(br.readLine());
    if(root.v == removeV) {
      System.out.println(0);
      return;
    }

    solve(root, removeV);
    System.out.println(result);
  }

  public static void solve(Node cur, int removeV) {

    boolean canGo = false;
    for(Node next: nodes) {
      if(next.p != cur.v) continue;
      if(next.v == removeV) continue;
      canGo = true;
      solve(next, removeV);
    }

    if(!canGo) result++;
  }
}

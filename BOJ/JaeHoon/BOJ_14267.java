package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14267 {
  static class Node {
    int num;
    ArrayList<Node> chilNodes = new ArrayList<>();
    int total;
    int valueSum;
    Node(int num) {
      this.num = num;
    }
  }
  static Node[] nodes;
  static int n;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    nodes = new Node[n+1];
    for(int i=1; i<=n; i++) {
      int parent = Integer.parseInt(st.nextToken());
      nodes[i] = new Node(i);
      if(parent == -1) continue;
      nodes[parent].chilNodes.add(nodes[i]);
    }

    for(int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      nodes[num].valueSum += value;
    }
    bfs();
    StringBuffer sb = new StringBuffer();
    for(int i=1; i<=n; i++) 
      sb.append(nodes[i].valueSum + " ");
    System.out.println(sb);
  }
  public static void bfs() {
    Queue<int[]> queue = new LinkedList<>();
    for(Node next: nodes[1].chilNodes) {
      // next.valueSum += nodes[1].valueSum;
      queue.add(new int[]{next.num, next.valueSum});
    }
    while(!queue.isEmpty()) {
      int[] curr = queue.poll();
      for(Node next: nodes[curr[0]].chilNodes) {
        next.valueSum += curr[1];
        queue.add(new int[]{next.num, next.valueSum});
      }
    }
  }
}
